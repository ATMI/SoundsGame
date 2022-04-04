package su.mya.soundsgame;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

	static class Digit {
		public final int iconRes;
		public final String soundRes;

		Digit(int iconRes, String soundRes) {
			this.iconRes = iconRes;
			this.soundRes = soundRes;
		}
	}

	static HashMap<Integer, Digit> digits = new HashMap<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		digits.put(R.id.d0, new Digit(R.drawable.digit_0, "sound_0.ogg"));
		digits.put(R.id.d1, new Digit(R.drawable.digit_1, "sound_1.ogg"));
		digits.put(R.id.d2, new Digit(R.drawable.digit_2, "sound_2.ogg"));
		digits.put(R.id.d3, new Digit(R.drawable.digit_3, "sound_3.ogg"));
		digits.put(R.id.d4, new Digit(R.drawable.digit_4, "sound_4.ogg"));
		digits.put(R.id.d5, new Digit(R.drawable.digit_5, "sound_5.ogg"));
		digits.put(R.id.d6, new Digit(R.drawable.digit_6, "sound_6.ogg"));
		digits.put(R.id.d7, new Digit(R.drawable.digit_7, "sound_7.ogg"));
		digits.put(R.id.d8, new Digit(R.drawable.digit_8, "sound_8.ogg"));
		digits.put(R.id.d9, new Digit(R.drawable.digit_nine, "sound_nine.ogg"));

		final ImageView display = findViewById(R.id.display);
		final MediaPlayer player = new MediaPlayer();

		final View.OnClickListener digitClick = new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				final Digit d = digits.get(view.getId());
				if (d == null)
					return;

				try {
					display.setImageResource(d.iconRes);
					final AssetFileDescriptor fd = getAssets().openFd(d.soundRes);
					player.reset();
					player.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(), fd.getLength());
					player.prepare();
					// player.setVolume(1f, 1f);
					player.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};

		for (Integer id : digits.keySet()) {
			findViewById(id).setOnClickListener(digitClick);
		}
	}
}