package analyst;



public class SocionicsType {
	
	private TypeEnum theType;
	
	public static SocionicsType ILE = new SocionicsType(TypeEnum.ILE);
	public static SocionicsType SEI = new SocionicsType(TypeEnum.SEI);
	public static SocionicsType ESE = new SocionicsType(TypeEnum.ESE);
	public static SocionicsType LII = new SocionicsType(TypeEnum.LII);
	public static SocionicsType EIE = new SocionicsType(TypeEnum.EIE);
	public static SocionicsType LSI = new SocionicsType(TypeEnum.LSI);
	public static SocionicsType SLE = new SocionicsType(TypeEnum.SLE);
	public static SocionicsType IEI = new SocionicsType(TypeEnum.IEI);
	public static SocionicsType SEE = new SocionicsType(TypeEnum.SEE);
	public static SocionicsType ILI = new SocionicsType(TypeEnum.ILI);
	public static SocionicsType LIE = new SocionicsType(TypeEnum.LIE);
	public static SocionicsType ESI = new SocionicsType(TypeEnum.ESI);
	public static SocionicsType LSE = new SocionicsType(TypeEnum.LSE);
	public static SocionicsType EII = new SocionicsType(TypeEnum.EII);
	public static SocionicsType IEE = new SocionicsType(TypeEnum.IEE);
	public static SocionicsType SLI = new SocionicsType(TypeEnum.SLI);
	
	                            
	                            
	private static enum TypeEnum {
		ILE,
		SEI,
		ESE,
		LII,
		EIE,
		LSI,
		SLE,
		IEI,
		SEE,
		ILI,
		LIE,
		ESI,
		LSE,
		EII,
		IEE,
		SLI		
	}
	

	public SocionicsType(TypeEnum type)	{
		theType = type;
	}	
	
	public String toString(){return typeName(theType);}
	
	public String typeName(TypeEnum type){
	 
		switch(type){
		case ILE   : return "��� (��� �����)";
		case SEI   : return "��� (����)";
		case ESE   : return "��� (����)";
		case LII   : return "��� (���������)";
		case EIE   : return "��� (������)";
		case LSI   : return "��� (������)";
		case SLE   : return "��� (�����)";
		case IEI   : return "��� (������)";
		case SEE   : return "��� (��������)";
		case ILI   : return "��� (�������)";
		case LIE   : return "��� (����)";
		case ESI   : return "��� (�������)";
		case LSE   : return "��� (�������)";
		case EII   : return "��� (�����������)";
		case IEE   : return "��� (������)";
		case SLI   : return "��� (�����)";
		default:return null; 
		 }	
	}
	
public static boolean matches(	SocionicsType type, 
								String aspect,  
								String secondAspect, 
								String sign, 
								String dimension, 
								String mv){

if (type == null) return false;
if (aspect == null) return false;
if (	secondAspect == null
		&&(sign==null ||(sign!=null && sign.equals(AData.PLUS)))
		&&(dimension==null || (dimension!=null && dimension.equals(AData.D1)))
		&& mv==null) 
					return true;
/////////////////////////////////////////////////////////////////////////////////////////
//��� �����
if (type.equals(SocionicsType.ILE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
					}else
						if (aspect.equals(AData.S)){
							if (!secondAspect.equals(AData.E)) return false;					
						}else
							if (aspect.equals(AData.F)){
								if (!secondAspect.equals(AData.R)) return false;					
							}else
								if (aspect.equals(AData.T)){
									if (!secondAspect.equals(AData.P)) return false;					
								}else
									if (aspect.equals(AData.I)){
										if (!secondAspect.equals(AData.L)) return false;					
									}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	|| 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)							
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||  dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//	|| 	mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
			//	|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
				//	||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
					|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	|| 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	|| 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end I

return true;
} //end ILE
//////////////////////////////////////////////////////////////////////////////////////////////////
//����
if (type.equals(SocionicsType.SEI)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.E)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.R)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.P)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.L)) return false;					
										}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
						//		dimension.equals(AData.MALOMERNOST)
								dimension.equals(AData.MNOGOMERNOST)
							||	dimension.equals(AData.ODNOMERNOST)
						//	||	dimension.equals(AData.INDIVIDUALNOST)							
						//	|| 	dimension.equals(AData.D2)
							|| 	dimension.equals(AData.D3)
							|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	|| 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
					mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//		dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
				//	|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I
return true;
} //end SEI
//////////////////////////////////////////////////////////////////////////////////////////////////
//����
if (type.equals(SocionicsType.ESE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.E)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.R)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.P)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.L)) return false;					
										}
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	|| 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
					mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//	||	dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end ESE	

//////////////////////////////////////////////////////////////////////////////////////////////////
//���������
if (type.equals(SocionicsType.LII)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.E)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.R)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.P)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.L)) return false;					
										}
			
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//		mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
			//	|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
					||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end LII	

//////////////////////////////////////////////////////////////////////////////////////////////////
//������
if (type.equals(SocionicsType.EIE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
					mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//		dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end EIE	

//////////////////////////////////////////////////////////////////////////////////////////////////
//������
if (type.equals(SocionicsType.LSI)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//		mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
			//	|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
					||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end LSI	

//////////////////////////////////////////////////////////////////////////////////////////////////
//�����
if (type.equals(SocionicsType.SLE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//		mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
			//	|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
				//	||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
					|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end SLE	

//////////////////////////////////////////////////////////////////////////////////////////////////
//������
if (type.equals(SocionicsType.IEI)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
					
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
					mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//		dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
				//	|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end IEI	

//////////////////////////////////////////////////////////////////////////////////////////////////
//��������
if (type.equals(SocionicsType.SEE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
					}else
						if (aspect.equals(AData.S)){
							if (!secondAspect.equals(AData.E)) return false;					
						}else
							if (aspect.equals(AData.F)){
								if (!secondAspect.equals(AData.R)) return false;					
							}else
								if (aspect.equals(AData.T)){
									if (!secondAspect.equals(AData.P)) return false;					
								}else
									if (aspect.equals(AData.I)){
										if (!secondAspect.equals(AData.L)) return false;					
									}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//		mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//	||	dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
					||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I
return true;
} //end SEE

/////////////////////////////////////////////////////////////////////////////////////////
//�������
if (type.equals(SocionicsType.ILI)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
					}else
						if (aspect.equals(AData.S)){
							if (!secondAspect.equals(AData.E)) return false;					
						}else
							if (aspect.equals(AData.F)){
								if (!secondAspect.equals(AData.R)) return false;					
							}else
								if (aspect.equals(AData.T)){
									if (!secondAspect.equals(AData.P)) return false;					
								}else
									if (aspect.equals(AData.I)){
										if (!secondAspect.equals(AData.L)) return false;					
									}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||  dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
				 	mv.equals(AData.MENTAL)	
			//	|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end I

return true;
} //end ILI

/////////////////////////////////////////////////////////////////////////////////////////
//����
if (type.equals(SocionicsType.LIE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.E)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.R)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.P)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.L)) return false;					
										}
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||  dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
				 	mv.equals(AData.MENTAL)	
			//	|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
				//	||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
					|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						|| 	dimension.equals(AData.D2)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//	||	dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end I

return true;
} //end LIE

//////////////////////////////////////////////////////////////////////////////////////////////////
//�������
if (type.equals(SocionicsType.ESI)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.I)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.T)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.F)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.S)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.E)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.R)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.P)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.L)) return false;	
										}	
		
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//		mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//	||	dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
					||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
				//	|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I
return true;
} //end ESI

//////////////////////////////////////////////////////////////////////////////////////////////////
//�������
if (type.equals(SocionicsType.LSE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
					mv.equals(AData.MENTAL)	
			//	|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
				//	||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
					|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end LSE	

//////////////////////////////////////////////////////////////////////////////////////////////////
//�����������
if (type.equals(SocionicsType.EII)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
					
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//		mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//		dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
					||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
				//	|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end EII	

//////////////////////////////////////////////////////////////////////////////////////////////////
//������
if (type.equals(SocionicsType.IEE)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
			
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
					 	mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
					mv.equals(AData.VITAL)
			//		mv.equals(AData.MENTAL)	
				|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
						dimension.equals(AData.MALOMERNOST)
				//		dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
					||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
				//	|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end IEE	

//////////////////////////////////////////////////////////////////////////////////////////////////
//�����
if (type.equals(SocionicsType.SLI)){

	//block
	if (secondAspect!=null){
		if (aspect.equals(AData.L)){
			if (!secondAspect.equals(AData.F)) return false;
		}else		
			if (aspect.equals(AData.P)){
				if (!secondAspect.equals(AData.S)) return false;			
			}else
				if (aspect.equals(AData.R)){
					if (!secondAspect.equals(AData.I)) return false;					
				}else
					if (aspect.equals(AData.E)){
						if (!secondAspect.equals(AData.T)) return false;					
						}else
							if (aspect.equals(AData.S)){
								if (!secondAspect.equals(AData.P)) return false;					
							}else							
								if (aspect.equals(AData.F)){
									if (!secondAspect.equals(AData.L)) return false;					
								}else
									if (aspect.equals(AData.T)){
										if (!secondAspect.equals(AData.E)) return false;					
									}else
										if (aspect.equals(AData.I)){
											if (!secondAspect.equals(AData.R)) return false;					
										}
	} //end Block
	
	//L
	if (aspect.equals(AData.L)){

			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end L
	//P
	if (aspect.equals(AData.P)){

			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//	 	mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end P
	//R
	if (aspect.equals(AData.R)){
		//if (sign !=null && sign.equals(AData.MINUS))return false;
		//mv
		if (mv!=null){
			if (	
			//		mv.equals(AData.VITAL)
					mv.equals(AData.MENTAL)	
			//	|| 	mv.equals(AData.SUPERID)
				|| 	mv.equals(AData.SUPEREGO)				
												)return false;
			
		}//end mv
		//dimension
		if (dimension!=null){
			if (		
				
				//		dimension.equals(AData.MALOMERNOST)
						dimension.equals(AData.MNOGOMERNOST)
					||	dimension.equals(AData.ODNOMERNOST)
				//	||	dimension.equals(AData.INDIVIDUALNOST)								
				//	|| 	dimension.equals(AData.D2)
					|| 	dimension.equals(AData.D3)
					|| 	dimension.equals(AData.D4)
													)return false;
		}//end dimension
			
		
	}//end R
	//E
	if (aspect.equals(AData.E)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end E
	//S
	if (aspect.equals(AData.S)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
					//	|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end S
	//F
	if (aspect.equals(AData.F)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
							dimension.equals(AData.MALOMERNOST)
					//		dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
					//	|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end F
	//T
	if (aspect.equals(AData.T)){
			//if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
						mv.equals(AData.VITAL)
				//		mv.equals(AData.MENTAL)	
					|| 	mv.equals(AData.SUPERID)
				//	|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
						||	dimension.equals(AData.ODNOMERNOST)
						||	dimension.equals(AData.INDIVIDUALNOST)								
					//	|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
				
			
	}//end T
	//I
	if (aspect.equals(AData.I)){
			if (sign !=null && sign.equals(AData.MINUS))return false;
			//mv
			if (mv!=null){
				if (	
				//		mv.equals(AData.VITAL)
						mv.equals(AData.MENTAL)	
				//	|| 	mv.equals(AData.SUPERID)
					|| 	mv.equals(AData.SUPEREGO)				
													)return false;
				
			}//end mv
			//dimension
			if (dimension!=null){
				if (		
					
					//		dimension.equals(AData.MALOMERNOST)
							dimension.equals(AData.MNOGOMERNOST)
					//	||	dimension.equals(AData.ODNOMERNOST)
					//	||	dimension.equals(AData.INDIVIDUALNOST)								
						|| 	dimension.equals(AData.D2)
						|| 	dimension.equals(AData.D3)
						|| 	dimension.equals(AData.D4)
														)return false;
			}//end dimension
	}//end I

return true;
} //end SLI
	
return false;	
}//end matches()

}//end class
