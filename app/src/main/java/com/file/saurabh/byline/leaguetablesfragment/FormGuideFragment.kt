package com.file.saurabh.byline.leaguetablesfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.file.saurabh.byline.R
import com.file.saurabh.byline.Utils.SVGUtils
import com.file.saurabh.byline.databinding.FragmentFormGuideBinding
import com.file.saurabh.byline.network.moshipropertyclasses.LeagueTable


class FormGuideFragment : Fragment() {
    private  val args by navArgs<FormGuideFragmentArgs>()
    private lateinit var currentTeamsFormGuide : LeagueTable.Table

    private lateinit var formGuideClubCrestImageView: ImageView
    private lateinit var formGuideClubNameTextView: TextView
    private lateinit var formGuidePositionTextView: TextView

    private lateinit var formGuideGoalsScoredTextView : TextView
    private lateinit var formGoalsConcededTextView : TextView

    private lateinit var pTextView: TextView
    private lateinit var wTextView: TextView
    private lateinit var dTextView: TextView
    private lateinit var lTextView: TextView
    private lateinit var ptsTextView: TextView
    private lateinit var gdTextView: TextView

    private lateinit var formGuideOne : TextView
    private lateinit var formGuideTwo : TextView
    private lateinit var formGuideThree : TextView
    private lateinit var formGuideFour : TextView
    private lateinit var formGuideFive : TextView


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentFormGuideBinding>(inflater,R.layout.fragment_form_guide,container,false)

        formGuideClubCrestImageView = binding.formGuideClubCrestImageView
        formGuideClubNameTextView = binding.formGuideClubNameTextView
        formGuidePositionTextView = binding.formGuidePositionTextView

        formGuideGoalsScoredTextView = binding.formGuideGoalsScoredTextView
        formGoalsConcededTextView = binding.formGoalsConcededTextView

        pTextView = binding.pTextView
        wTextView = binding.wTextView
        dTextView = binding.dTextView
        lTextView = binding.lTextView
        ptsTextView = binding.ptsTextView
        gdTextView = binding.gdTextView

        formGuideOne = binding.formGuideOne
        formGuideTwo = binding.formGuideTwo
        formGuideThree = binding.formGuideThree
        formGuideFour = binding.formGuideFour
        formGuideFive = binding.formGuideFive


        currentTeamsFormGuide = args.currentTeamsFormGuide



        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        formGuidePositionTextView.text = currentTeamsFormGuide.position.toString()
        formGuideClubNameTextView.text = currentTeamsFormGuide.team.name
        SVGUtils.fetchSvg(view.context,currentTeamsFormGuide.team.crestUrl,formGuideClubCrestImageView)


        formGuideGoalsScoredTextView.text = currentTeamsFormGuide.goalsFor.toString()
        formGoalsConcededTextView.text = currentTeamsFormGuide.goalsAgainst.toString()

        pTextView.text = currentTeamsFormGuide.playedGames.toString()
        wTextView.text = currentTeamsFormGuide.won.toString()
        dTextView.text = currentTeamsFormGuide.draw.toString()
        lTextView.text = currentTeamsFormGuide.lost.toString()
        gdTextView.text = currentTeamsFormGuide.goalDifference.toString()
        ptsTextView.text = currentTeamsFormGuide.points.toString()

        val results = currentTeamsFormGuide.form?.split(",")

        formGuideOne.text = results?.get(0).toString()
        formGuideTwo.text = results?.get(1).toString()
        formGuideThree.text = results?.get(2).toString()
        formGuideFour.text = results?.get(3).toString()
        formGuideFive.text = results?.get(4).toString()

        val formTextViewsList = listOf<TextView>(formGuideOne,
                formGuideTwo,
                formGuideThree,
                formGuideFour,
                formGuideFive)

        for(textView in formTextViewsList){
            when(textView.text){
                "L" -> textView.setBackgroundColor(resources.getColor(R.color.design_default_color_error))
                "W" -> textView.setBackgroundColor(resources.getColor(R.color.green))
                "D" -> textView.setBackgroundColor(resources.getColor(R.color.browser_actions_divider_color))
            }
        }

    }

}