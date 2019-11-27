package com.ssm.test;

import java.util.BitSet;
import java.util.Random;

public class BitMap {
	private int[] data;//BitMap
	private final int BITS=32;//数组中的存储单元为32位
	private final int SHIFT=5;//2^5=32
	private final int MASK=0x1F;//0001 1111=31
	public BitMap(int nums){
		data=new int[1+nums/BITS];
	}
	/**
	 * 向BitMap添加一个元素，其中value>>SHIFT和1<<(value&MASK)是实现映射的关键
	 * @param value
	 */
	public void add(int value){
		int index=value>>SHIFT;//删掉低5位，相当于value/32
		int bit=1<<(value&MASK);//只保留低5位，相当于value%31，把1往右移(<value&MASK)位
		data[index]=data[index]|bit;
	}
	/**
	 * 从bitmap中删除value
	 * @param value
	 */
	public void clr(int value){
		int index=value>>SHIFT;
		int bit=1<<(value&MASK);
		bit=~bit;
		data[index]=data[index]&bit;
	}
	/**
	 * 从bitmap中寻找value
	 * @param value
	 * @return
	 */
	public boolean find(int value){
		int index=value>>SHIFT;
		int bit=1<<(value&MASK);
		if((data[index]&bit)!=0)
			return true;
		else
			return false;
	}
	public static void main(String[] args){
		BitMap bm=new BitMap(10000000);
		bm.add(23);
		bm.add(35);
		bm.add(24);
		bm.add(43);
		System.out.println(bm.find(24));
		int code = 999288464;
		for(int i = 1;i<1000000;i++){
			Random random = new Random();
			int a = random.nextInt();
		}
		System.err.println(code);
		int [] array = new int [] {1,2,3,22,0,3,5,63,code};
        BitSet bitSet  = new BitSet();
        //将数组内容组bitmap
        for(int i=0;i<array.length;i++){
            bitSet.set(array[i], true);
        }
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(3));
        System.out.println(bitSet.get(8));
    }
}
