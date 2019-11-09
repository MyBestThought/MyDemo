package com.interview1;

public class ImitateSqrt {
    public static void main(String[] args){
        System.out.println("hello");
        System.out.println(imitated1(10));
        System.out.println(imitated1(121));
        System.out.println(imitated1(0.16F));
        System.out.println(imitated1(16));
        System.out.println("*****************************");
        System.out.println(imitated2(10));
        System.out.println(imitated2(121));
        System.out.println(imitated2(0.16F));
        System.out.println(imitated2(16));
        System.out.println("*****************************");
        System.out.println(imitated3(10));
        System.out.println(imitated3(121));
        System.out.println(imitated3(0));
        System.out.println(imitated3(16));
    }

    /**
     * 二分法实现开方功能
     * @param num
     * @return
     */
    public static float imitated1(float num){
        float max = num, min = 0;
        float mid = (max + min) /2;
        float temp = 0;
        while(Math.abs(mid-temp) > 0.01){

            if(mid * mid > num){
                max = mid;
            }else{
                min = mid;
            }
            temp = mid;
            mid = (max + min) / 2;
        }
        return mid;
    }

    /**
     * 牛顿迭代法
     * @param num
     * @return
     */
    public static double imitated2(double num){
        double x = num, y =0;
        while(Math.abs(x- y) > 0.1){
            y = x;
            x = 0.5 * (x + num / x);
        }
        return x;
    }

    public static int imitated3(int num){
        if(num == 0){
            return 0;
        }
        int left = 1, mid = 0, right = num;
        int result = 0;
        while(left < right){
            mid = (left + right) /2;
            if(mid == num / mid){
                result = mid;
                break;
            }else if(mid > num / mid){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }
}
