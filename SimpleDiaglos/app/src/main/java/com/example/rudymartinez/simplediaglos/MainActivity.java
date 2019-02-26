package com.example.rudymartinez.simplediaglos;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);

        DialogConf.setTitle("Confirmation Dialog");
        DialogConf.setMessage("This is the Text of the Dialog");
        DialogConf.setIcon(R.mipmap.ic_launcher);


        DialogConf.setNeutralButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(MainActivity.this, "You closed the dialog.", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog MyDialog = DialogConf.create();
        MyDialog.show();


        AlertDialog.Builder SecondDialogConf = new AlertDialog.Builder(this);

        SecondDialogConf.setTitle("Confirmation Dialog");
        SecondDialogConf.setMessage("This is the Text of the Dialog");
        SecondDialogConf.setIcon(R.mipmap.ic_launcher);

        SecondDialogConf.setPositiveButton("Yeah",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You answer yes.", Toast.LENGTH_SHORT).show();
                    }
                });

        SecondDialogConf.setNegativeButton("Nel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You answer no.", Toast.LENGTH_SHORT).show();
                    }
                });

        SecondDialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "You close the dialog.", Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog MySecondDialog = SecondDialogConf.create();
        MySecondDialog.show();

        AlertDialog.Builder ThirdDialogConf = new AlertDialog.Builder(this);

        ThirdDialogConf.setTitle("Confirmation Dialog");
        ThirdDialogConf.setMessage("This is the Text of the Dialog");
        ThirdDialogConf.setIcon(R.mipmap.ic_launcher);

        final EditText TextInput = new EditText(context);
        TextInput.setTextColor(Color.BLUE);
        ThirdDialogConf.setView(TextInput);


        ThirdDialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String str = TextInput.getEditableText().toString();
                        Toast.makeText(context, "You wrote this in the dialog: " + str, Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyThirdDialog = ThirdDialogConf.create();
        MyThirdDialog.show();


        /*Step 5: Bar Notification ---------------------------------------------------------------*/

        int NOTIF_ID = 1234;
        Notification.Builder NotifBuilder = new Notification.Builder(this);
        NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotifBuilder.setContentTitle("Important Notification");
        NotifBuilder.setContentText("This is the detail of the notification");

        Intent notificationIntent = new Intent(context, ChildActivity.class);
        notificationIntent.putExtra("myData", "This string comes from the previous activity");
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        NotifBuilder.setContentIntent(contentIntent);

        NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        MyNotification.notify(NOTIF_ID, NotifBuilder.build());
    }
}
