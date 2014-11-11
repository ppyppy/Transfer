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
	    
	    //if want to return double
	    public double sqrt(int x) {
	        if(x<0)
	            return -1;
	        double low=0, high=x/2+1;
	        while(low<=high){
	            double mid = (low+high)/2;
	            if( Math.abs(mid*mid-(long)(x))<0.01)
	                return mid;
	            else if(mid*mid<x){
	                low = (mid+0.01);
	            }else{
	                high = (mid-0.01);
	            }
	        }
	        return high;
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