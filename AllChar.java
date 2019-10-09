//字母大小全排列
//示例:
//输入: S = "a1b2"
//输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
public class AllChar {
    List<String> list = new ArrayList<>();
    int dis = 'A' - 'a';
    public List<String> letterCasePermutation(String S) {
        if(S.length() == 0){
            return list;
        }
        char[] ch = S.toCharArray();
        dealArray(ch, 0);
        return list;
    }
    public void dealArray(char[] ch, int index){
        list.add(String.valueOf(ch));
        for(int i=index; i < ch.length; i++){
            if(ch[i] >= '0' && ch[i] <= '9'){
                continue;
            }else if(ch[i] >= 'a' && ch[i] <= 'z'){
                ch[i] = (char)(ch[i]+dis);
                dealArray(ch, i+1);
                ch[i] = (char)(ch[i] - dis);
            }else{
                ch[i] = (char)(ch[i]-dis);
                dealArray(ch, i+1);
                ch[i] = (char)(ch[i] + dis);
            }
        }
    }
}