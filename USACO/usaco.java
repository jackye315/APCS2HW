public class usaco{
    int R;
    int C;
    int E;
    int N;

    int [][]pasture=new int [R][C];

    public void dig(r,c,d){
	int x=r+3;
	int y=c+3;
	int max=pasture[r][c];
	while(r<x){
	    while(c<y){
	    if(max<pasture[r][c]){
		max=pasture[r][c];
	    }
	    c=c+1;
	    }
	    r=r+1;
	}
	int newmax=max-d;
	while(r<x){
	    while(c<y){
		if(newmax<pasture[r][c]){
		    pasture[r][c]=newmax;
		}
		c=c+1;
	    }
	    r=r+1;
	}
    }

    public void lake(){
	int x=0;
	while(x<R){
	    int y=0;
	    while(y<C){
		if(E>pasture[r][c]){
		    pasture[r][c]=E-pasture[r][c];
		}
		else{
		    pasture[r][c]==0;
		}
		y=y+1;
	    }
	    x=x+1;
	}
    }

    
    public int findLakeVolume(int [][]pasture,int r,int c,int d,int E,int N,int R,int C){
	while(N>0){
	dig(r,c,d);
	N=N-1;
	}
	lake();
	int x=0;
	int ans=0;
	while(x<R){
	    int y=0;
	    while(y<C){
		ans=ans+pasture[R][C];
		y=y+1;
	    }
	    x=x+1;
	}
	ans=ans*72*72;
	return ans;



    }


    /////////////////////////////////////


    public int cowpaths(char[][]pasture,int r1, int c1, int r2, int c2, int T){
	int ans=0;
	int currentr=r1;
	int currentc=c1;
	if(T==0 && currentr==r2 && currentc==c2){
	    ans=ans+1;
	}
	else{
	    //I couldn't solve this




}
