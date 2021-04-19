package hk.edu.cuhk.ie.iems5722.a1_1155159018;

public class Msg {
    public static final int TYPE_RECEIVED=0;
    public static final int TYPE_SENT=1;
    private String content;
//    private String time;
    private int type;
    public Msg(String content, int type){
        this.content = content;
        this.type = type;
//        this.time = time;
    }
    public String getContent(){
        return content;
    }
    public int getType(){
        return type;
    }
}

