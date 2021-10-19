package hard;


/**
 * 正则表达式
 * 力扣：https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class RegMatch {

    public static void main(String[] args){
        System.out.println(match("aa","a"));
        System.out.println(match("aa","a*"));
        System.out.println(match("ab",".*"));
        System.out.println(match("aab","c*a*b"));
        System.out.println(match("mississippi","mis*is*p*."));
    }

    public static boolean match(String s,String p){

        if(s==null||p==null){
            return false;
        }

        int searchIndex=0;
        char lastSearchChar=0;

        int i=0;
        for(;i<p.length();i++){
            if(searchIndex>s.length()-1){
                return false;
            }
            char c = p.charAt(i);
            if(c=='.'){
                lastSearchChar=s.charAt(searchIndex);
                searchIndex++;
            }else if(c=='*'){
                if(i==0||p.charAt(i-1)=='*'){
                    throw new IllegalArgumentException("*号不能独立存在且不能出现连续两个*");
                }else if(p.charAt(i-1)=='.'){
                    return true;
                }else{
                    while(searchIndex<s.length()&&s.charAt(searchIndex)==lastSearchChar){
                        searchIndex++;
                    }
                }
            }else if(c==s.charAt(searchIndex)){
                lastSearchChar=s.charAt(searchIndex);
                searchIndex++;
            }else if(c!=s.charAt(searchIndex)){
                //如果匹配不上，则判断后续是否是*
                if(p.charAt(i+1)=='*'){
                    searchIndex++;
                    i++;
                }else{
                    return false;
                }
            }


        }
        return searchIndex==s.length();
    }
}
