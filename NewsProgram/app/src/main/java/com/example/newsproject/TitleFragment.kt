package com.example.newsproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsproject.databinding.ActivityMainBinding
import com.example.newsproject.databinding.FragmentTitleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTitleBinding.inflate(inflater, container, false)
        val view = binding.root

        val newsData = NewsData()
        val adapter = MainAdapter(newsData)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        return view
    }

    private fun NewsData(): List<NewsItem> {
        return listOf(
            NewsItem(
                "‘유퀴즈’ 이준기, 과거 연예인 병에 걸렸다고 솔직하게 고백해",
                "30일 방송된 tvN 간판 예능프로그램 ‘유퀴즈 온 더 블럭’에서 게스트로 믿고 보는 배우 이준기가 출연했다." +
                        "이날 이준기는 과거 슬럼프를 이겨낸 경험과 포기 하지 않고 끊임없이 배우려는 의지와 열정적인 모습을 드러냈다.\n" +
                        "\n" +
                        "영화 ‘왕의 남자’는 이준기의 인생에서 빼놓을 수 없는 대표작이다. 영화계에 혜성같이 등장한 이준기는 ‘왕의 남자’로 처음부터 전성기를 맞이했다. ‘N차 관람’의 시초이자 ‘왕남 폐인’이라는 신조어까지 만들어 낸 ‘왕의 남자’에 대해 이준기는 “영화 자체의 메시지와 끝나고 난 이후의 여운에 빠지셨던 것 같다. 그 삶에 빗대본 사람이 많은 것 같다”라고 말했다.\n" +
                        "\n" +
                        "무려 3000:1의 경쟁률을 뚫고 당당히 합격한 이준기는 “무조건 캐스팅 역을 따야 할 때였다. 신인에게 너무 큰 기회였기 때문에 영혼이라도 팔 수 있다고 생각했다. 실제로 인생을 바꿔준 계기였다. 마지막에 두세 분 중에서 고민했다고 했다”라며 캐스팅 비화를 떠올렸다.\n" +
                        "이준기는 “신인이니까 연기는 미흡하니 열심히 하자 싶어서 신체 연기를 위해 학교 다닐 때부터 아크로바틱을 다치면서도 매일 연습했다. 텀블링, 묘기, 사물놀이를 미리 연습해서 갔다”라며 “왕 앞에서 광대 연기를 하다가 다리를 벌리는 신이 있었다. 그 아이디어를 제가 만들어서 보여줬는데 거기서 다 터졌다. 뭔가 한 거 같다 싶었다. 거기서 느낌이 왔다.”라며 당시의 열정을 드러냈다.\n" +
                        "\n" + "이준기는 왕의 남자를 촬영할 때 이준익 감독이 따로 강조한 게 있었냐는 질문에 “사물놀이패 안에서 합숙을 통해 같이 배웠다. 감독님이 공길이 되려면 숙소 방 밖으로 나오지 말라고 명령했다. 제가 쾌활하니 말도 줄이라고 해서 그렇게 넉 달을 살았다”라고 답해 눈길을 끌었다.\n" +
                        "\n" + "눈 떠보니 스타가 된 것에 대해서 이준기는 “너무 감사했다. 지금 같은 경우 대 히트작이 나와도 3~5개월이 지나면 교체가 되는데 그때는 1년 동안 영화 ‘왕의 남자’ 하나로 이후에 같이 했던 것들이 다 잘되다 보니 제 개인적으로 잘못된 생각에 빠졌다”라며 “세상은 나로부터 돌아가는구나, 생각했다. 나약해진 나 자신 안에서 나오는 건방짐에 빠져있었던 것 같다”라고 부끄럽다는 듯이 고백했다.\n" +
                        "\n" + "솔직하게 연예인 병을 인정할 수 있게 된 이유에 대해 이준기는 “그런 것들로부터 탈피했다는 자신감 때문인 것 같다”라며 “신인 때부터 함께해 온 주변 사람들이 가장 먼저 안다. 그분들의 솔직하고 옳은 말을 듣고 보니 이렇게 살다가 내가 배우를 접어야 할 것 같았다. 지금이라도 바뀌지 않으면 많은 사람에게 폐를 끼칠 것 같다고 생각했다”라고 밝혔다.\n" +
                        "\n" + "이준기는 “저는 타고난 배우가 아니다. 무조건 노력을 해야 하고 너무 일찍이 사랑을 받아 삶의 경험도 많지 않아서 제가 느낄 수 있는 경험과 가치들은 오로지 현장에 있는 사람에게서 받는다. 내가 의지할 수 있는 건 사람이구나 싶어 방법을 꾸준히 찾는다”라며 “배우라는 직업은 언젠가 끝이 있고 늘 대체되기 때문에 제가 잘 살아오면서 천천히 활강하다 멋있게 착륙하고 싶다”라고 본인의 바람을 밝혔다.\n",
                "2023.08.31",
                R.drawable.sample_0
            ),
            NewsItem("제목", "기사내용", "날짜", R.drawable.sample_0),
        )
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TitleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}