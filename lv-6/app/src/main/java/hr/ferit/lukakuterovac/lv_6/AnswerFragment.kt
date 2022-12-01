package hr.ferit.lukakuterovac.lv_6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class AnswerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_answer, container, false)

        val playerNameView = view.findViewById<TextView>(R.id.playerNameText)
        playerNameView.text = arguments?.getString("PLAYER").toString()

        val backButton = view.findViewById<Button>(R.id.backButton)

        backButton.setOnClickListener {
            val choiceFragment = ChoiceFragment()
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView, choiceFragment)
            transaction?.commit()
        }

        return view
    }
}