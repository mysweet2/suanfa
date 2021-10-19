package hard;

public class FindMiddleNumber {


    public static void main(String[] args){
        int[] nums1=new int[]{2,3,5};
        int[] nums2=new int[]{1,4,7};
        double result=findMiddleNumber(nums1,nums2);
        System.out.println(result);
    }


    public static double findMiddleNumber(int[] nums1,int[] nums2){
        if(nums1==null&&nums2==null){
            return 0;
        }else if(nums1==null||nums2==null){
            return findFromArr(nums1!=null?nums1:nums2);
        }else{
            int scanedIndexCount=0;
            int nums1ScanIndex=0;
            int nums2ScanIndex=0;
            int totalLength=nums1.length+nums2.length;
            int currNumber=-Integer.MAX_VALUE;

            int middleNumIndex=0;
            if(totalLength%2==0){
                middleNumIndex=totalLength/2-1;
            }else{
                middleNumIndex=totalLength/2;
            }


            int middle0=0;
            int middle1=0;
            //如果还有数据可以扫描
            while((nums1ScanIndex<=nums1.length-1||nums2ScanIndex<=nums2.length-1)){
                if(nums1ScanIndex<=nums1.length-1&&nums2ScanIndex<=nums2.length-1){
                    if(nums1[nums1ScanIndex]<=nums2[nums2ScanIndex]){
                        currNumber=nums1[nums1ScanIndex];
                        nums1ScanIndex++;
                    }else{
                        currNumber=nums2[nums2ScanIndex];
                        nums2ScanIndex++;
                    }
                }else if(nums1ScanIndex<=nums1.length-1){
                    currNumber=nums1[nums1ScanIndex];
                    nums1ScanIndex++;
                }else{
                    currNumber=nums1[nums1ScanIndex];
                    nums1ScanIndex++;
                }


                scanedIndexCount++;

                if(scanedIndexCount-1==middleNumIndex){
                    middle0=currNumber;
                    if(totalLength%2==1){
                        middle1=middle0;
                        break;
                    }
                }else if(scanedIndexCount-1==middleNumIndex+1&&totalLength%2==0){
                    middle1=currNumber;
                    break;
                }

            }

            return new Double((middle0+middle1)+"")/2;
        }
    }


    public static double findFromArr(int [] nums){
        if(nums.length%2==0){
            int sum=nums[nums.length/2-1]+nums[nums.length/2];
            return Double.parseDouble(sum+"")/2;
        }else{
            return nums[nums.length/2];
        }
    }

}
