
package cn.svanur.yingxiaohao;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private final static String first = "" + '\t' + '\t' + '\t' + '\t';
    private Toolbar tbMain;
    private EditText etBody;
    private EditText etEvent1;
    private EditText etEvent2;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tbMain = (Toolbar) findViewById(R.id.tb_main);
        etBody = (EditText) findViewById(R.id.et_body);
        etEvent1 = (EditText) findViewById(R.id.et_event1);
        etEvent2 = (EditText) findViewById(R.id.et_event2);
        tvResult = (TextView) findViewById(R.id.tv_result);
        tvResult.setText(first+"我这么帅是怎么回事呢？我相信大家都很熟悉，但是我这么帅是怎么回事呢，下面就让小编带大家一起了解吧。\n" +
                first+"我这么帅，其实就是非常好看，大家可能会很惊讶我怎么会非常好看呢？但事实就是这样，小编也感到非常惊讶。\n" +
                first+"这就是关于我这么帅的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！");

        setSupportActionBar(tbMain);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void generateText(View view) {
        String body = etBody.getText().toString();
        String event1 = etEvent1.getText().toString();
        String event2 = etEvent2.getText().toString();

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(first + body + event1 + "是怎么回事呢？" + body + "相信大家都很熟悉，但是" + body + event1 + "是怎么回事呢，下面就让小编带大家一起了解吧。"+'\n'
                + first + body + event1 + "，其实就是" + event2 + "，大家可能会很惊讶" + body + "怎么会" + event2 + "呢？但事实就是这样，小编也感到非常惊讶。"+'\n'
                + first + "这就是关于" + body + event1 + "的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！"
        );

        tvResult.setText(stringBuffer.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.item1);
        SpannableString spannableString = new SpannableString(item.getTitle());
        spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, spannableString.length(), 0);
        item.setTitle(spannableString);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                AlertDialog alertDialog = builder.setTitle("关于软件")
                        .setMessage("本软件仅供娱乐!请勿用作商业目的!")
                        .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .create();
                alertDialog.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
