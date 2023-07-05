package com.ab.mobo.internet;
import com.ab.mobo.R;
import com.ab.mobo.display.displayhome;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.ab.mobo.MainActivity;

public class broadcastinternet  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
          boolean nointernet = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);


          if (nointernet){
             AlertDialog.Builder builder=new AlertDialog.Builder(context);
              builder.setCancelable(false);
              builder.setTitle("Connectivity Alert ");
              builder.setMessage("Please check your internet connection");
              builder.setPositiveButton("try again", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      context.startActivity(new Intent(context, displayhome.class));
                  }
              });
              AlertDialog alertDialog=builder.create();
              alertDialog.getWindow().getAttributes().windowAnimations= R.style.myanimationdialog;
              alertDialog.show();


          }
      }
    }
}
