package com.ibm.feedback;

public class FeedbackException extends Exception 
	{ 
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public FeedbackException(String code) 
	    { 
	      super(code);
	}

			
			public FeedbackException(FeedbackException e) 
		    { 
		      super(e);
		} 
		
	}

