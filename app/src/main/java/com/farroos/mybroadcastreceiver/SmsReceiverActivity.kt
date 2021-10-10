package com.farroos.mybroadcastreceiver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farroos.mybroadcastreceiver.databinding.ActivitySmsReceiverBinding

class SmsReceiverActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME_NO = "extra_name_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    private var binding: ActivitySmsReceiverBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySmsReceiverBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        title = getString(R.string.incoming_message)

        binding?.btnClose?.setOnClickListener {
            finish()
        }

        val senderNo = intent.getStringExtra(EXTRA_NAME_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)

        binding?.tvFrom?.text = getString(R.string.from, senderNo)
        binding?.tvMessage?.text = senderMessage
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}