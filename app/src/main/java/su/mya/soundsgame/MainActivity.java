package su.mya.soundsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final ImageView digitView = findViewById(R.id.digit);

		final MediaPlayer player = new MediaPlayer();
		final View.OnClickListener digitClick = new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int icon = R.drawable.digit_0;
				String sound = "sound_";
				final int id = view.getId();

				if (R.id.d0 == id) {
					sound += "0";
					icon = R.drawable.digit_0;
				} else if (R.id.d1 == id) {
					sound += "1";
					icon = R.drawable.digit_1;
				} else if (R.id.d2 == id) {
					sound += "2";
					icon = R.drawable.digit_2;
				} else if (R.id.d3 == id) {
					sound += "3";
					icon = R.drawable.digit_3;
				} else if (R.id.d4 == id) {
					sound += "4";
					icon = R.drawable.digit_4;
				} else if (R.id.d5 == id) {
					sound += "5";
					icon = R.drawable.digit_5;
				} else if (R.id.d6 == id) {
					sound += "6";
					icon = R.drawable.digit_6;
				} else if (R.id.d7 == id) {
					sound += "7";
					icon = R.drawable.digit_7;
				} else if (R.id.d8 == id) {
					sound += "8";
					icon = R.drawable.digit_8;
				} else if (R.id.d9 == id) {
					sound += "nine";
					icon = R.drawable.digit_nine;
				}

				try {
					digitView.setImageResource(icon);
					final AssetFileDescriptor fd = getAssets().openFd(sound + ".ogg");
					player.reset();
					player.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
					player.prepare();
					player.setVolume(1f, 1f);
					player.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		findViewById(R.id.d0).setOnClickListener(digitClick);
		findViewById(R.id.d1).setOnClickListener(digitClick);
		findViewById(R.id.d2).setOnClickListener(digitClick);
		findViewById(R.id.d3).setOnClickListener(digitClick);
		findViewById(R.id.d4).setOnClickListener(digitClick);
		findViewById(R.id.d5).setOnClickListener(digitClick);
		findViewById(R.id.d6).setOnClickListener(digitClick);
		findViewById(R.id.d7).setOnClickListener(digitClick);
		findViewById(R.id.d8).setOnClickListener(digitClick);
		findViewById(R.id.d9).setOnClickListener(digitClick);
	}
}