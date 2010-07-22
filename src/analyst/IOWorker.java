package analyst;

import java.awt.Frame;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import analyst.ADocument.ASection;
import analyst.ADocument.RawAData;

public class IOWorker  extends SwingWorker implements PropertyChangeListener{
	
	private FileInputStream fis;
	private FileOutputStream fos;
	boolean append = false;
	private String plainText = null;
	private ADocument aDoc;
	HashMap<ADocument.ASection, AData> aData = null;
	Analyst frame;
	private ProgressWindow pw;
	private Operation op;
	private Exception exception = null;
	private boolean textDataLoaded = false;
	private boolean rawDataLoaded = false;
	private boolean docLoaded = false;
	private int appendOffset = 0;
	private Hashtable <Integer, ADocument.RawAData>  rawData = null;
	
	
	IOWorker(ProgressWindow pw, ADocument aDoc, FileInputStream fis){
		this.fis = fis;
		this.aDoc = aDoc;
		this.frame = pw.getAnalyst();		
		this.pw = pw;
		this.op=Operation.LOAD;
		
		this.addPropertyChangeListener(pw);

	}

	IOWorker(ProgressWindow pw, ADocument aDoc, FileOutputStream fos){
		this.fos = fos;
		this.aDoc = aDoc;
        this.frame = pw.getAnalyst();		
		this.pw = pw;
		this.op=Operation.SAVE;
		

		addPropertyChangeListener(pw);
		addPropertyChangeListener(frame);
		addPropertyChangeListener(this);

	}
	
	
	@Override
	protected Object doInBackground() throws Exception {
		addPropertyChangeListener(this);
		try{
		if (op.equals(Operation.LOAD))aDoc.load(fis, append, this);
		if (op.equals(Operation.SAVE))aDoc.save(fos, this);
		} catch (Exception e){
			pw.close();
			this.exception = e;
		}
		
		
		return null;
	}
	
	protected final void setProgressValue(int p){
		setProgress(p);
	}
	
	protected void done(){
		super.done();
		pw.close();
	}
	
	protected void setAppend(boolean append){
		this.append = append;		
	}

	
public static final class 	Operation {
	public static Operation LOAD = new Operation();
	public static Operation SAVE = new Operation();	
	
}
	
public ProgressWindow getProgressWindow(){return pw;}

@Override
public void propertyChange(PropertyChangeEvent evt) {
	
	String name = evt.getPropertyName();
	Object newValue = evt.getNewValue();
	Object oldValue = evt.getOldValue();
		
	// if we are loading file
	if (op.equals(Operation.LOAD)){
		//updating Document Properties
		if (name.equals("DocumentProperty")){
			Dictionary <Object, Object> props = aDoc.getDocumentProperties();
			String docPropName = (String)oldValue;
				if (docPropName!=null) {
					props.remove(docPropName);
					props.put(new String(docPropName), new String((String)newValue));
				}
		}
		if (name.equals("TextData")){
			//getting plain text
				plainText = (String) newValue;
				appendOffset = Integer.parseInt((String)oldValue);
				textDataLoaded = true;
		}
		
		if (name.equals("RawData")){
			
			//getting AData
			rawData = (Hashtable <Integer, RawAData> )newValue;
			rawDataLoaded = true;
		}
		
		if (!docLoaded && textDataLoaded && rawDataLoaded){
	
			try{	
				if (!append) {
					aDoc.getADataHashMap().clear();
				}
				
				aDoc.insertString(appendOffset, plainText, aDoc.defaultStyle);
				
				Iterator <ADocument.RawAData> it =  (rawData.values()).iterator();
				RawAData temp = null;
				while(it.hasNext()){
					temp = it.next();
					AData ad=null;
					
						ad = AData.parceAData(temp.getAData());
						String ggg = temp.getComment();
						ad.setComment(temp.getComment());
						int beg = temp.getBegin();
						int end = temp.getEnd();
						
						aDoc.getADataHashMap().put(aDoc.createASection(beg+appendOffset, end+appendOffset), ad);
						aDoc.setCharacterAttributes(beg+appendOffset, end-beg, aDoc.defaultSectionAttributes, false);
				}
				aDoc.fireADocumentChanged();
				
			} catch (Exception e){
				pw.close();
				this.exception = e;
				this.cancel(true);
			}
			

		docLoaded = true;		
			
		}
				
	}//if load

	
	// if we are saving file
	if (op.equals(Operation.SAVE)){
		
		// so far nothing to do on the dispatch thread
	}
}

public Exception getException(){ return exception;}

}
