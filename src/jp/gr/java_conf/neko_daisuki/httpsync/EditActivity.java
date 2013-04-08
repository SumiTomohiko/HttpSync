package jp.gr.java_conf.neko_daisuki.httpsync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class EditActivity extends Activity {

    private class OkButtonOnClickListener implements View.OnClickListener {

        public void onClick(View _) {
            ok();
        }
    }

    private class CancelButtonOnClickListener implements View.OnClickListener {

        public void onClick(View _) {
            cancel();
        }
    }

    public static final String EXTRA_KEY_JOB = "job";

    private EditText mUrlEditText;
    private EditText mDirectoryEditText;
    private CheckBox mOverwriteCheckBox;

    private Job mJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        mUrlEditText = (EditText)findViewById(R.id.url_text);
        mDirectoryEditText = (EditText)findViewById(R.id.directory_text);
        mOverwriteCheckBox = (CheckBox)findViewById(R.id.overwrite_checkbox);

        mJob = (Job)getIntent().getSerializableExtra(EXTRA_KEY_JOB);
        mUrlEditText.setText(mJob.url);
        mDirectoryEditText.setText(mJob.directory);
        mOverwriteCheckBox.setChecked(mJob.overwrite);

        View okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new OkButtonOnClickListener());
        View cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new CancelButtonOnClickListener());
    }

    private void ok() {
        Job job = new Job();
        job.id = mJob.id;
        job.url = mUrlEditText.getText().toString();
        job.directory = mDirectoryEditText.getText().toString();
        job.overwrite = mOverwriteCheckBox.isChecked();

        Intent i = getIntent();
        i.putExtra(EXTRA_KEY_JOB, job);
        close(RESULT_OK, i);
    }

    private void cancel() {
        close(RESULT_CANCELED, null);
    }

    private void close(int resultCode, Intent i) {
        setResult(resultCode, i);
        finish();
    }
}

/**
 * vim: tabstop=4 shiftwidth=4 expandtab softtabstop=4
 */
