public class array2d {
   public static boolean search2d(int [][]arr,int target){
    int r = arr.length;
    int c = arr[0].length;
    int low = 0;
    int high = r * c -1;
while (low <= high) {
    int mid= (low + high )/2;
 int row = mid/r;
 int col = mid%c;
 if(arr[row][col]==target)
 return true;
 else if(arr[row][col]<target)
  low = mid +1;
  else 
  high= mid -1;
}
return false;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,2,3},{4,5,6}};
      
        int target = 2;
      boolean ans =   search2d(arr,target);
      System.out.println(ans);
    }
}
