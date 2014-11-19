	    public int sqrt(int x) {
	        if(x<0)
	            return -1;
	        long low=0, high=x/2+1;
	        while(low<=high){
	            long mid = (low+high)/2;
	            if(mid*mid==(long)(x))
	                return (int)mid;
	            else if(mid*mid<x){
	                low = (mid+1);
	            }else{
	                high = (mid-1);
	            }
	        }
	        return (int) high;
	    }
	    
       double epsilon = 0.000000000000001;
       double sqrt2(double d) {
    	    assert(d>0);
    	    if(d<1) return sqrt2(d*100)/10.0;
    	    double start=1.0, end = d;
    	    double m = (start+end)/2.0;
    	    while(Math.abs(d-m*m)>epsilon) {
    	        if(m*m<d) start = m;
    	        else end = m;
    	        m = (start+end)/2.0;
    	    }
    	    return m;
    	  }
	    
	    
	    //Reference: http://www.drdobbs.com/184409869;jsessionid=AIDFL0EBECDYLQE1GHOSKH4ATMY32JVN

	    //	Algorithm: Newton's Approximation Method
	    //double situation
	    double sqrt12( unsigned long N )
	    {
	        double n, p, low, high;
	        if( 2 > N )
	            return( N );
	        low  = 0;
	        high = N;
	        while( high > low + 1 )
	        {
	            n = (high + low) / 2;
	            p = n * n;
	            if( N < p )
	                high = n;
	            else if( N > p )
	                low = n;
	            else
	                break;
	        }
	        return( N == p ? n : low );
	    }  
