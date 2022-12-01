package hr.ferit.lukakuterovac.lv_6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

class ChoiceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_choice, container, false)

        val nextButton = view.findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroup)
            val radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            val chosenPlayer = radioButton.text.toString()

            val answerFragment = AnswerFragment()
            val bundle = Bundle()
            bundle.putString("PLAYER", chosenPlayer)
            answerFragment.arguments = bundle

            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView, answerFragment)
            transaction?.commit()
        }

        return view
    }
}