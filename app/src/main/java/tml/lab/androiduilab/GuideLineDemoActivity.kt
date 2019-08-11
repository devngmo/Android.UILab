package tml.lab.androiduilab

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_guide_line_demo.*
import android.R
import android.graphics.Typeface
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.Toast
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetSequence
import com.takusemba.spotlight.OnSpotlightStateChangedListener
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.target.SimpleTarget


class GuideLineDemoActivity : AppCompatActivity() {
    companion object {
        val ARG_ENGINE_ID = "engine.id"
    }

    var engineID : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tml.lab.androiduilab.R.layout.activity_guide_line_demo)
        setSupportActionBar(toolbar)

        engineID = intent.extras.getInt(ARG_ENGINE_ID, 0)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        setupTapTarget()
        setupSpotlight()
        restartGuideLine()
    }

    lateinit var spotlight: Spotlight
    fun setupSpotlight() {
        val btnSpotlight = SimpleTarget.Builder(this)
            .setTitle("Guideline with Spotlight")
            //.setPoint(findViewById<View>(tml.lab.androiduilab.R.id.btnGuideLineWithSpotlight))
            .setPoint(100.0f,100.0f)
            .build()

        spotlight = Spotlight.with(this)
            .setOverlayColor(R.color.darker_gray)
            .setDuration(1000L)
            .setAnimation(DecelerateInterpolator(2f))
            .setTargets(btnSpotlight)
            .setClosedOnTouchedOutside(false)
//            .setOnSpotlightStateListener()

        //    .start()
    }

    lateinit var tapTargetSequence: TapTargetSequence
    private fun setupTapTarget() {
        tapTargetSequence = TapTargetSequence(this).targets(
            //TapTargetView.showFor(this, // `this` is an Activity
            TapTarget.forView(
                findViewById(tml.lab.androiduilab.R.id.fab), "This is a target", "We have the best targets, believe me")
                .outerCircleColor(R.color.holo_red_dark)      // Specify a color for the outer circle
                .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                .targetCircleColor(R.color.white)   // Specify a color for the target circle
                .titleTextSize(20)                  // Specify the size (in sp) of the title text
                .titleTextColor(R.color.white)      // Specify the color of the title text
                .descriptionTextSize(10)            // Specify the size (in sp) of the description text
                .descriptionTextColor(R.color.holo_red_dark)  // Specify the color of the description text
                .textColor(R.color.white)            // Specify a color for both the title and description text
                .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                .dimColor(R.color.black)            // If set, will dim behind the view with 30% opacity of the given color
                .drawShadow(true)                   // Whether to draw a drop shadow or not
                .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                .tintTarget(true)                   // Whether to tint the target view's color
                .transparentTarget(false)           // Specify whether the target is transparent (displays the content underneath)
                //.icon(Drawable)                     // Specify a custom drawable to draw as the target
                .targetRadius(60), // Specify the target radius (in dp)
            TapTarget.forView(
                findViewById(tml.lab.androiduilab.R.id.btnGuideLineWithTapTarget), "Guideline by Tap Target", "Using Tap Target engine"),
            TapTarget.forView(
                findViewById(tml.lab.androiduilab.R.id.btnGuideLineWithSpotlight), "Guideline by Spotlight", "Using Spotlight engine")

        ).listener(object: TapTargetSequence.Listener {
            override fun onSequenceCanceled(lastTarget: TapTarget?) {

            }

            override fun onSequenceFinish() {
                Toast.makeText(this@GuideLineDemoActivity, "Guideline Finished", Toast.LENGTH_SHORT).show()
            }

            override fun onSequenceStep(lastTarget: TapTarget?, targetClicked: Boolean) {
            }
        })
//            object :
//                TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
//                override fun onTargetClick(view: TapTargetView) {
//                    super.onTargetClick(view)      // This call is optional
//                    //doSomething()
//                }
//            })
    }

    private fun restartGuideLine() {
        if (engineID == 0) {
            restartGuideLine_TapTarget()
        } else if (engineID == 1) {
            restartGuideLine_Spotlight()
        }
    }

    fun guidelineWithTapTarget(v:View) {
        restartGuideLine_TapTarget()
    }
    fun guidelineWithSpotlight(v:View) {
        restartGuideLine_Spotlight()
    }

    private fun restartGuideLine_Spotlight() {
        spotlight.start()
    }

    private fun restartGuideLine_TapTarget() {
        tapTargetSequence.start()
    }

}
