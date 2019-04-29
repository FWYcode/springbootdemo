//package com.it.utils.sort.heapsort;
//
//import java.util.Arrays;
//
///**
// * Created by Administrator on 2019/4/22 0022.
// */
//public class HeapSort {
//    //private static int[]temp;
//
//
//    /**
//     * 传入待排序数据进行分治
//     */
//    public static int[] fz(int[] arr) {
//        //int[] temp=arr;
//
//        int left=(arr.length)/2;
//        fz(arr, 0, arr.length-1);
//
//        return arr;
//    }
//
//    private static void fz(int[] arr, int left, int right) {
//        int mid= (left + right) / 2;
//        if (left < right) {
//            fz(arr,left,mid);
//            fz(arr, mid+1, right);
//            sort(arr, left, mid, right);
//
//        }
//    }
//
//    private static void sort(int[] a, int left, int mid, int right) {
//
//        int[] temp = new int[right-left+1];
//        int i= left;
//        int j = mid+1;
//        int k=0;
//        // 把较小的数先移到新数组中
//        while(i<=mid && j<=right){
//            if(a[i]<a[j]){
//                temp[k++] = a[i++];
//            }else{
//                temp[k++] = a[j++];
//            }
//        }
//        // 把左边剩余的数移入数组
//        while(i<=mid){
//            temp[k++] = a[i++];
//        }
//        // 把右边边剩余的数移入数组
//        while(j<=right){
//            temp[k++] = a[j++];
//        }
//        // 把新数组中的数覆盖nums数组
//        for(int x=0;x<temp.length;x++){
//            a[x+left] = temp[x];
//        }
//        //System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(temp));
//    }
//
//
//    public static void main(String[] args) {
//        int[] arr = {688,300,102,56,31,65,46,8,4,7,5,3,1,2,0};
//       arr= fz(arr);
//
//    }
//}
