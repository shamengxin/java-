package com.shemengxin.java.search;

import java.util.Arrays;

/**
 * 斐波那契查找算法（数组必须有序）
 * 思路：首先将数组扩容到斐波那契数列其中一个值的大小（要求：fib[k-1]-1<n and fib[k]-1>n)，然后将此数组扩容到
 * 这个值的大小，将数组的最后一个数向扩容数组多余部分填充，以便于比较。然后利用斐波那契数组的原理f[k]=f[k-1]+f[k-2]，
 * 找到黄金分割点mid=low(数组开头的元素）+f[k-1]-1,与需要查找的数进行对比，如果大于则将low向右移动，小于则将high向
 * 左移动，就会有两种结果，一种是数组剩余数为f[k-1],另一种是数组剩余数为f[k-2],然后在将这些剩余的数继续分隔，找黄金
 * 分割点，继续对比，左右移动即可。
 *
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println(fibSearch(arr,32));
    }

    //因为后面我们mid=low+F[k-1]-1,需要使用到斐波那契数列，因此我们需要先获取到斐波那契数列
    //非递归的方式得到一个斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //编写斐波那契查找算法
    //使用非递归的方式编写算法

    /**
     * @param a   数组
     * @param key 需要查找的关键码（值）
     * @return 返回对应下标，如果没有-1
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;//存放mid值
        int[] f = fib();//获取到斐波那契数列
        //获取到斐波那契分割数组的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]值可能大于a的长度，因此我们需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //实际上需要使用a数组最后的数填充temp
        for (int i = high + 1; i < temp.length - 1; i++) {
            temp[i] = a[high];
        }

        //使用while来循环处理，找到我们的数key
        while (low <= high) {//只要这个条件满足，就可以找
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//说明我们应该继续向数组的前面查找（左边)
                high = mid - 1;
                //为什么k--
                //说明：
                //1.全部的元素=前面的元素+后面的元素
                //2.f[k]=f[k-1]+f[k-2]
                //因为前面有f[k-1]个元素，所以可以继续拆分f[k-1]=f[k-2]+f[k-3]
                //即在f[k-1]的前面继续查找k--
                //即下次循环mid=f[k-1-1]-1
                k--;
            } else if (key > temp[mid]) {//说明我们应该继续向数组的后面查找（右边)
                low = mid+1;
                //为什么是k-=2
                //说明
                //1.全部的元素=前面的元素+后面的元素
                //2.f[k]=f[k-1]+f[k-2]
                //因为总元素个数为f[k],所以low向后移动，就会减少f[k-1]个元素，high向前移动，就会减少f[k-2]个元素
                //然后在对剩下的元素个数继续进行拆分，找到黄金分割点，以此类推，直到找到要查找元素为止，或是找不到。
                //3.因为后面我们有f[k-2]个元素，所以可以继续拆分f[k-2]=f[k-3]+f[k-4]
                //4.即在f[k-2]的前面进行查找k-=2
                //5.即下次循环mid=f[k-1-2]-1
                k-=2;
            }else {//找到
                //需要确定，返回的是那个下标
                if(mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}
