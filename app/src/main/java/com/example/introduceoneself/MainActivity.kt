package com.example.introduceoneself

import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import java.util.Arrays

class MainActivity : AppCompatActivity(), OnClickListener, OnGestureListener, OnTouchListener{

    lateinit var img:ImageView
    lateinit var btnME:Button
    lateinit var btnGraduate:Button
    lateinit var btnCoding:Button
    lateinit var btnGame:Button
    lateinit var btnSing:Button
    lateinit var btnVideo:Button
    lateinit var gDetector:GestureDetector
    lateinit var txv:TextView
    lateinit var mediaPlayer: MediaPlayer
    lateinit var btnPlay: Button
    lateinit var btnPause: Button
    lateinit var btnStop: Button
    var count:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer()
        mediaPlayer = MediaPlayer.create(this, R.raw.kataomoi)

        btnPlay = findViewById(R.id.btnPlay)
        btnPlay.setOnClickListener({
            mediaPlayer.start()
            btnPlay.isEnabled = false
            btnPause.isEnabled = true
            btnStop.isEnabled = true
        })

        btnPause = findViewById(R.id.btnPause)
        btnPause.setOnClickListener({
            mediaPlayer.pause()
            btnPlay.isEnabled = true
            btnPause.isEnabled = false
            btnStop.isEnabled = true
        })

        btnStop = findViewById(R.id.btnStop)
        btnStop.setOnClickListener({
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(this, R.raw.kataomoi)
            btnPlay.isEnabled = true
            btnPause.isEnabled = false
            btnStop.isEnabled = false
        })

        img = findViewById(R.id.img)
        img.setOnTouchListener(this)

        btnME = findViewById(R.id.btnMe)
        btnME.setOnClickListener(this)

        btnGraduate = findViewById(R.id.btnGraduate)
        btnGraduate.setOnClickListener(this)

        btnCoding = findViewById(R.id.btnCoding)
        btnCoding.setOnClickListener(this)

        btnGame = findViewById(R.id.btnGame)
        btnGame.setOnClickListener(this)

        btnSing = findViewById(R.id.btnSing)
        btnSing.setOnClickListener(this)

        btnVideo = findViewById(R.id.btnVideo)
        btnVideo.setOnClickListener(this)

        txv = findViewById(R.id.txv)

        gDetector = GestureDetector(this, this)
    }

    private fun NotSing() {
        btnPlay.visibility = View.GONE
        btnPause.visibility = View.GONE
        btnStop.visibility = View.GONE
        if (mediaPlayer != null && mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    override fun onClick(v: View?) {
        if (v == btnME) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.sparrow1))
            count = 1
            txv.text = "關於我"
            NotSing()
        }
        else if (v == btnGraduate) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.sparrow2))
            count = 2
            txv.text = "未來規劃"
            NotSing()
        }
        else if (v == btnCoding) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.sparrow3))
            count = 3
            txv.text = "程式語言"
            NotSing()
        }
        else if (v == btnGame) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.sparrow4))
            count = 4
            txv.text = "興趣"
            NotSing()
        }
        else if (v == btnSing) {
            img.setImageDrawable(getResources().getDrawable(R.drawable.sparrow5))
            count = 5
            txv.text = "唱歌"
            NotSing()
        }
        else {
            img.setImageDrawable(getResources().getDrawable(R.drawable.sparrow6))
            count = 6
            txv.text = "追劇 & 實況"
            NotSing()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gDetector.onTouchEvent(event)
        return true
    }

    override fun onDown(p0: MotionEvent): Boolean {
        return true
    }

    override fun onShowPress(p0: MotionEvent) {
    }

    override fun onSingleTapUp(p0: MotionEvent): Boolean {
        if (count == 1) {
            txv.text = "嗨嗨！我是王韻淳\n目前就讀於靜宜大學資管系4年級"
            NotSing()
        }
        else if (count == 2) {
            txv.text = "在今年六月我就要畢業啦！"
            NotSing()
        }
        else if (count == 3) {
            txv.text = "目前正在學習python爬蟲\n目前習得：java、python、SQL、c++、kotlin、html\n但都不專精還需加強"
            NotSing()
        }
        else if (count == 4) {
            txv.text = "遊戲玩得很爛，但還是很喜歡玩遊戲\n只要是免費遊戲都玩d(`･∀･)b"
            NotSing()
        }
        else if (count == 5) {
            txv.text = "超級喜歡唱歌\n我自己覺得是唱的不錯，也有人誇獎過(๑• . •๑)"
            NotSing()
        }
        else if (count == 6) {
            txv.text = "日劇、陸劇、台劇都有追，熱愛古裝劇\n陸劇：周生如故 台劇：牛車來去、她和她的她\n日劇：狂賭之淵、silent"
            NotSing()
        }
        return true
    }

    override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {
        return true
    }

    override fun onLongPress(p0: MotionEvent) {
        if (count == 1) {
            txv.text = "綽號是'粟鳥仔'(台語，國語：麻雀)\n因為我小小一隻的又很愛說話\n所以家人就幫我取了這個綽號\n也就有了這張代表圖"
            NotSing()
        }
        else if (count == 2) {
            txv.text = "未來打算當工程師\n至於哪方面的工程師還不確定\n也想去考考公職"
            NotSing()
        }
        else if (count == 3) {
            txv.text = "最近想學資安\n但還一直沒時間學_(┐「ε:)_"
            NotSing()
        }
        else if (count == 4) {
            txv.text = "喜歡聽日文和中文歌(๑´ㅂ`๑)\n日文：Yuika - Sukidakara\n中文：艾薇Ivy - 癡心無名氏"
            NotSing()
        }
        else if (count == 5) {
            txv.text = "意外吧~竟然有我唱的歌可以聽(・∀・)\n覺得好聽可以聽一下，不好聽也沒關係"
            btnPlay.visibility = View.VISIBLE
            btnPause.visibility = View.VISIBLE
            btnStop.visibility = View.VISIBLE
        }
        else if (count == 6) {
            txv.text = "Twitch淺水仔，喜歡看各種妹子台、搞笑台跟節目\n最愛主播：林芙芙、依渟、小熊、咪咪蛋、小亮"
            NotSing()
        }
    }

    override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
        if (e1.x <= e2.x){
            count++
            if (count > 6) {
                count = 1
            }
        }
        else{
            count --
            if (count < 1){
                count = 6
            }
        }
        var res:Int = getResources().getIdentifier("sparrow" + count.toString(),
            "drawable", getPackageName())
        img.setImageDrawable(getResources().getDrawable(res))
        return true
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if (v == img){
            if (count == 1) {
                txv.text = "ㄟㄟ別抓我啦( ˘･з･)"
                NotSing()
            }
            else if (count == 2) {
                txv.text = "要帶我走未來的路嗎？ε٩(๑> ₃ <)۶з"
                NotSing()
            }
            else if (count == 3) {
                txv.text = "沒看到我在打程式嗎？(☉д⊙)"
                NotSing()
            }
            else if (count == 4) {
                txv.text = "別吵！玩得正開心ㄟ(#`皿´)"
                NotSing()
            }
            else if (count == 5) {
                txv.text = "喜歡聽我唱歌嗎？ヽ(●´∀`●)ﾉ"
                NotSing()
            }
            else if (count == 6) {
                txv.text = "要推薦好看的劇還是可愛的實況主嗎？(✪ω✪)"
                NotSing()
            }
        }
        if (event?.action == MotionEvent.ACTION_MOVE){
            v?.x = event.rawX-v!!.width/2
            v?.y = event.rawY-v!!.height/2
        }
        return true
    }
}
