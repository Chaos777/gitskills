package task;

import java.util.HashSet;
import java.util.Set;

public class Youdao3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dic = new HashSet<>();
		dic.add("leet");
		dic.add("code");
		dic.add("s");
		String s = "leetcode";
		System.out.println(dfs(s, dic, 0, 0));
		System.out.println(word(s,dic));
	}
	
	/**
	 * 法一：深度搜索
	 * */
	public static boolean dfs(String s,Set<String>dic,int start,int cur){
		if(cur==s.length()){
			return dic.contains(s.substring(start,cur));
		}
		if(dfs(s, dic, start, cur+1)){
			return true;
		}
		if(dic.contains(s.substring(start, cur+1))){
			if(dfs(s, dic, cur+1, cur+1)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 法二：动态规划
	 * 
	 * */
	public static boolean word(String s,Set<String>dic){
		boolean f[]= new boolean[s.length()+1];
		f[0] = true;
		for(int i=1;i<=s.length();i++){
			for(int j=i-1;j>=0;j--){
				if(f[j]&&dic.contains(s.substring(j, i))){
					f[i] = true;
					break;
				}
			}
		}
		return f[s.length()];
	}

}
