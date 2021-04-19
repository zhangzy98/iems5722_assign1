package hk.edu.cuhk.ie.iems5722.a1_1155159018;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class ChatActivity extends AppCompatActivity {

    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList=new ArrayList<Msg>();




    Button button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(hk.edu.cuhk.ie.iems5722.a1_1155159018.ChatActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

//        initMsgs();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:MM");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));  //设置时区
        Date curTime = new Date(System.currentTimeMillis());
        String timestr = simpleDateFormat.format(curTime);
       // String s = String.format("%30s", timestr);




        adapter=new MsgAdapter(hk.edu.cuhk.ie.iems5722.a1_1155159018.ChatActivity.this,R.layout.msg_item,msgList);
        inputText=(EditText)findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        msgListView=(ListView)findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if(!"".equals(content)){
                    String newcontent = inputText.getText().append("\n"+timestr).toString();
                    Msg msg=new Msg(newcontent,Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                }
            }
        });

    }

//    private void initMsgs() {
//        Msg msg1=new Msg("test1",Msg.TYPE_RECEIVED);
//        msgList.add(msg1);
//        Msg msg2=new Msg("test2",Msg.TYPE_SENT);
//        msgList.add(msg2);
//        Msg msg3=new Msg("test3",Msg.TYPE_RECEIVED);
//        msgList.add(msg3);
//    }


}

