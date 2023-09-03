package com.example.newsproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsproject.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var binding: FragmentTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
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

        adapter.itemClick = object : MainAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                // 항목 클릭시 처리
                val selectedItem = newsData[position]
                val selectedArticle = selectedItem.article
                val selectedDate = selectedItem.date
                val selectedTitle = selectedItem.title
                val selectedImage = selectedItem.image

                val bundle = Bundle()
                bundle.putParcelable("selected", selectedItem)
                bundle.putString("title", selectedTitle)
                bundle.putString("article", selectedArticle)
                bundle.putString("date", selectedDate)
                bundle.putInt("image", selectedImage)

                // bundle을 detailfragmentㅀ 전달
                DetailFragment().arguments = bundle

                val detailFragment = DetailFragment.newInstance(selectedItem)
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, detailFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return view
    }

    private fun NewsData(): List<NewsItem> {
        // 데이터 원본
        return listOf(
            NewsItem(
                "이재명 피의자 출석 미루다 4일 만에 '소환 조사에 응하겠다'",
                "더불어민주당 이재명 대표는 9월 4일 '쌍방울 불법 대북 송금' 사건에 대해 피의자로 검찰에 나와 조사를 받는다고 민주당이 오늘 1일 밝혔다. 지난 31일부터 무기한 단식 중인 이 대표는 검찰의 '4일 출두' 보고에 9월 정기국회 본회의가 없는 11일~15일에 출석하겠다고 대항하다 4일 돌연 소환 조사를 받겠다고 입장을 뒤집었다.\n" +
                        "\n" + "그러하나 이 사건을 수탐하던 수원 지검은 \"2시간 조사를 하고 중단하는 것은 안 된다\"라는 입장을 나타냈으며 \" 이 대표가 4일 오전엔 2시간만 조사받겠다고 검찰에 알렸다\"라는 입장이었다.\n" +
                        "\n" + "이에 수원 지검은 \" 준비된 전체 조사를 진행하겠다\"라고 밝혔다. 이날 브리핑에 참석한 민주당 강선우 대변인은 “본인의 검찰 조사에 있어서도 당당히 응한다는 입장을 거듭 밝혔다\"라며 \"이재명 대표는 사즉생의 각오로 단식 투쟁에 나서면서도 당무 일정을 정상 소화하며 투쟁한다는 기조를 다시 한번 강조했다\"라고 했다.\n" +
                        "\n" +
                        "이어 강 대변인은 \"일시 조정이 불가능한 일정 등을 고려할 때 4일에는 1차로 오전 조사를 실시하고 다음 주중 검찰과 협의해 추가 조사를 진행하겠다. 이 같은 입장은 오전에 검찰에 전달됐고 현재 협의 중”이라며 “이에 따라 이재명 대표는 검찰이 고집하는 오는 4일 출석하겠다”고 했다.\n" +
                        "\n" + "그러면서 그는 “오염수 투기를 반대하는 각국 관계자들이 직접 국회에 모이거나 화상으로 실시간 참여해 방류 중단을 논의하는 최초의 국제회의”라며 “참고로, 4일 오후에는 후쿠시마 오염수 해양 투기 철회 국제 공동회의가 예정돼 있다”고 했다.\n" +
                        "\n" +
                        "이어 “검찰에 이 대표 입장을 전달했고, 현재 검찰 입장을 기다리는 중”이라고 했다. 그는 “4일 1차 오전 조사를 받고, 그다음 주 중에 검찰 조사 후 추가 조사를 받을 것”이라고 밝혔다.\n" +
                        "\n" + "한편 이 대표 4일 출석 입장 발표가 나오자 수원 지검은 “어제(8월 31일) 이재명 대표 측 변호인에게 국회 본회의 일정이 없는 9월 4일 출석해 조사받을 것을 다시 한번 요구하였으나, 변호인으로부터 ‘9월 4일에는 출석이 불가능하고 9월 11~15일 중에 출석하겠다’는 통보받았다\"고 했다.\n" +
                        "\n" + "수원 지검은 또 “이재명 대표 측 변호인은 오늘(1일) 오전 수원 지검 수사팀에 연락해, 기존의 입장과는 달리 ‘9월 4일 출석해 오전 2시간만 조사받을 것이며, 오후에는 국회 일정으로 더 조사받을 수 없고 나머지 조사는 9월 11~15일 중에 출석해 받겠다’고 통보했다\"고 밝혔다.\n" +
                        "\n" + "이어 “일반적인 피의자의 출석과 조사에 관한 형사 사법 절차에 응해 줄 것으로 기대한다”란 입장을 내비치며 “최초 8월 30일로 조사 일정을 정해 출석 요구했으나, 이재명 대표의 ‘불가’하다며 다시 출석 요구한 9월 4일 오전 2시간 만에 조사를 중단할 수는 없으며, 준비된 전체 조사를 진행하겠음을 변호인에게 알렸다\"고 했다.\n" +
                        "\n" +
                        "한편, 이재명 대표는 단식 농성장에 위치한 최고위원 회의에서 “저의 단식 때문에 어제 많은 분이 이곳을 찾아주셨는데 꼭 이렇게 해야 하느냐 이런 말씀들이 많았다\"라며 “저의 대답은 그렇다. 이거 외에는 할 수 있는 게 없다\"고 관련 입장을 전하기도 했다.\n",
                "2023.09.01", R.drawable.sample_4
            ),
            NewsItem(
                "구글에 맞서고 싶어\"... 1300억 제안 거절한 30대 한국 청년",
                "오상훈 럭스로보 창업가는 총 4곳의 글로벌 기업으로부터 럭스로보 인수 제안이 왔지만 모두 거절했다고 밝혔다.\n2007년 애플이 아이폰을 내놓으며 글로벌 이동통신 시장의 변화를 일으켰다. 본격적으로 스마트폰 시장이 커지기 시작한 건 그 대항마가 등장하면서부터이다. 2008년 안드로이드가 나오며 기존의 휴대폰 제조사들은 본격 아이폰과 경쟁을 펼치게 됐다. 구글은 안드로이드를 오픈 소스로 풀어서 스마트폰의 생태계를 구축했다. \n" +
                        "\n" + "소프트웨어와 하드웨어의 가교 역할을 하는 OS 중요성이 높아지고 있다. IT 산업에서 인공지능과 사물 인터넷이 미래의 먹거리로 부상하며 반도체 칩의 사용이 늘어났고 OS 수요도 이에 맞게 확대됐다. 전문가들은 애플, 구글, 마이크로소프트 등 '갑 오브 갑'으로 떠오르게 된 이유도 독자적인 모바일용 운영체제를 등에 업었기 때문이라고 분석했다. \n" +
                        "\n" + "럭스로보 창업자 오상훈은 2014년 자신이 직접 개발한 MCU용 OS인 '모디 OS'를 기반으로서 창업을 하며 MS와 구글, 애플에 도전장을 냈다. 23일 서초구 럭스로보 본사에서 본 오상훈 창업자는 \"2017년 글로벌 기업이 '1억 달러' 약 1320억 원에 인수하고 싶다고 제안을 했지만 거절했다. 럭스로보를 크게 키울 자신이 있었기 때문이다. 한국의 첫 글로벌 플랫폼 회사로서 구글에 맞서는 회사로 만들고 싶다\"라고 당찬 포부를 밝혔다. \n" +
                        "\n" +
                        "전자제품에서 '두뇌' 역할을 하는 비메모리 반도체 칩인 MCU는 컴퓨터에서는 중앙처리장치인 CPU, 스마트폰 애플리케이션 프로세서인 AP가 있다면 자동차, 전자제품 각종 기기에서는 MCU가 같은 역할을 한다. 디바이스가 최근 더 정교해지고 loT 기기가 급증하며 MCU 수요가 늘고 있다. \n" +
                        "\n" + "'모디 OS'는 초보자도 쉽게 MCU 칩의 하드웨어와 소프트웨어 설계를 할 수 있게 통합 OS를 구현하는 것이 특징이다. 필요한 소자를 자동으로 추천하고 이것을 바탕으로 회로를 구상하면 3D 도면을 만든다. 사용자는 도면대로 소자를 주문해서 조립만 하면 된다. 조립한 칩은 컴퓨터에 연결하면 모디 OS가 자동 설정해 코딩까지 해준다.\n" +
                        "\n" +
                        "오 창업자는 \"MCU 설계 시에 회로와 펌웨어 코딩 파트 엔지니어가 따로 있어요. 코딩 엔지니어가 완벽하게 회로를 이해한 상태로 프로그래밍해야 한다. 실제 개발 현장에서 두 엔지니어가 서로가 맞다는 갈등이 잦다.\n" +
                        "\n" + "범용 OS가 있으면 현장 혼선도 줄고 개별 칩 제조사들이 개발하는 데에 들이는 시간과 비용을 아낄 수 있다. 럭스로보의 첫 번째 목표는 펌웨어와 회로 엔지니어 7천만 명 중에 10만 명을 럭스로보의 고객으로 만드는 것이다\"라고 말했다.\n" +
                        "\n" + "한국과학기술원 조성호 교수는 \"모디 OS는 중소 가전제품과 전자기기 등에 최적화되어 있고 저가형 MCU에서 동작하면서 군집 기반으로 작동하는 게 장점이다. PC와 스마트폰 OS가 탑재된 후 다양한 서비스가 생겨났다. 모디 OS가 loT용으로 활용한다면 MCU 플랫폼 혁신 기술로도 평가받을 수 있을 것이다\"고 말했다.\n",
                "2023.08.31",
                R.drawable.sample_2
            ),
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
            NewsItem(
                "사상 최고치 엔비디아, 구글과 손잡다",
                "인공지능(AI)의 엔비디아가 구글과 협력을 발표함으로써 주가가 사상 최고치를 깨뜨렸다.\n" +
                        "\n" + "29일 뉴욕증시에서 엔비디아는 전 거래일 기준 4.16% 폭등한 가격 487.84달러를 달성했다. 이는 사상 최고치이며 이전 최고치는 8월 24일 달성했던 483달러였다. 이에 따라 시가총액도 1조2,000억 달러를 경신한 1조2,050억 달러를 달성했고 올들어 234% 폭등했다.\n" +
                        "\n" +
                        "엔비디아의 주가가 최고치를 경신한 것은 엔비디아와 구글의 알파벳이 파트너십을 발표했기 때문으로 예측되며 이렇게 구글과 파트너십을 맺고 AMD와 인텔과의 거리를 벌리고 있다.\n" +
                        "\n" + "양사는 전 세계 구글 클라우드 고객들이 엔비디아의 AI 기술을 이용해 슈퍼컴퓨터를 더 간편하게 이용할 수 있도록 하는 데 보탬을 주기로 하겠다고 밝혔다.\n" +
                        "\n" + "젠슨 황 엔비디아 경영자는 \"구글과 공조 확대는 개발자들이 에너지 효율성을 높이고 돈을 절감하는 인프라, 및 서비스로 작업을 가속하는 데 보탬이 될 것\"이라고 말했다.\n" +
                        "\n" +
                        "매출은 135억 1,000만 달러라고 말했고 이 또한 시장의 예상치 112억 2,000만 달러를 크게 상회하며 매출은 전년 대비해서 88% 급증했다.\n" +
                        "\n" + "이와 같은 실적발표에도 엔비디아의 주가는 지난주 침체를 면치 못했으나 구글과 파트너십 발표를 기회로 급등한 것으로 보인다.\n",
                "2023.08.30",
                R.drawable.sample_6
            ),
            NewsItem(
                "마약류 약품 빼돌린 20대 대학병원 간호사 들통났다. 전 남자친구의 신고로 밝혀진 범행",
                "20대 대학병원 간호사인 A씨가 마약류 약품을 빼돌려 마약류 관리법 위반 혐의로 경찰에 입건 되었다.\n" +
                        "\n" + "20대 간호사 A 씨의 범죄행위는 전 남자친구의 신고로 인해 밝혀졌으며 타인의 이름으로 진통제 코데인을 처방받아 불법으로 소지한 혐의를 받고 있다. 코데인이란 기침이나 통증을 완화하는 약물인데 중독성이 심해서 현재 미국에서는 큰 골칫거리로 거론되고 있는 약품이다.\n" +
                        "\n" + "전 남자친구는 A 씨와 헤어진 다음 A 씨의 물건을 정리하다 모르는 사람의 이름으로 처방받은 것으로 추정되는 약과 함께 '마약류'라고 적혀있는 약봉지를 보고 경찰에 신고했다.\n" +
                        "\n" +
                        "경찰은 A씨가 마약을 투약했는지, 어떤 방식으로 빼돌렸는지 등을 추가 조사할 계획이라고 밝혔다.",
                "2023.08.29",
                R.drawable.sample_1
            ),

            NewsItem(
                "인천 한 마트에서 또 묻지마 흉기 난동 사건 발생했다.",
                "28일 인천에 위치한 할인마트에서 또 묻지마 흉기 난동 사건이 발생해 경찰이 수사에 나섰다.\n" +
                        "\n" + "이날 인천 서부경찰서에 따르면 오후 2시 57분쯤 인천시 서구 석남동에 위치한 할인마트에서 일면식도 없는 마트 안에 있던 손님과 마트 종업원을 향해 흉기를 휘두른 A씨를 체포했다고 밝혔다.\n" +
                        "\n" +
                        "마트에서 흉기를 휘두른 A씨는 범행 직후 도주했다가 2시간 20여 분이 지난 같은 날 오후 5시 20분경 지인의 집에서 경찰에 긴급 체포됐다.\n" +
                        "\n" +
                        "경찰은 A씨를 특수협박 혐의로 수사를 진행하고 있으며 정확한 범행 동기에 대해서도 조사를 하고 있다.\n" +
                        "\n" + "범행 당시 A씨는 야외 매대를 정리하고 있던 마트 종업원에게 다가가 삿대질을 하면서 실랑이를 벌였고 이어 뒷주머니에서 흉기를 꺼내 위협을 한 것으로 전해졌다.\n" +
                        "\n" +
                        "또한 위협을 받은 마트 종업원이 A씨를 피해 도망을 치자 A씨는 마트 안으로 들어가 계산대 앞에 있는 종업원에게도 흉기를 들고 고함을 치는 등 난동을 부렸다.\n" +
                        "\n" + "이러한 흉기 난동 사건에 마트 주변 일대는 공포에 질렸고, 다행히 이번 사건으로 인한 피해자는 없는 것으로 전해졌다.\n" +
                        "\n" + "경찰 조사에 따르면 A씨는 경찰에 전화를 걸어 “마트 사장을 살해하고 싶다”는 취지의 말을 한 것으로 전해졌으며, A씨는 “과일값이 비싸 범행했다”고 진술한 것으로 밝혀졌다.\n" +
                        "\n" + "이러한 범행에 인근 주민들은 A씨가 평소에 이상 행동을 많이 보여왔으며, 한 주민은 “여기 빌라에 사는 사람이다. 저기서 나오는 것을 몇 번 봤다”며 A씨가 마트 인근 주민인 것을 말해주었다.\n" +
                        "\n" +
                        "또한 “그런 사람은 오랫동안 잡아놔야지. 어디 밤에 무서워서 다니겠냐”며 불안을 호소하기도 했다.\n" +
                        "\n" + "한편 경찰은 A씨가 마트에서 범행을 저지른 정확한 시간과 동기 등 자세한 사건 경위를 조사하고 있으며, 경찰 관계자에 따르면 “현재 피해자와 피의자 조사가 되지 않아 구체적인 사건 경위는 조사해 봐야 하며 수사 후 적용 혐의와 구속영장 신청 여부를 결정할 것”이라고 전했다.\n",
                "2023.08.29", R.drawable.sample_3
            ),
            NewsItem(
                "후쿠시마 오염수 8월 말 방류 전망에 인천시 특별 단속에 나서",
                "'요미우리신문'과 '아사히신문'은 7일 일본 정부가 후쿠시마 제1 원자력발전소의 오염수(이하 '처리수'라 한다) 방류 시기를 조율하고 있다고 보도했다.\n" +
                        "\n" + "일본 정부는 저인망 어업이 후쿠시마현 앞바다에서 시작되는 9월 1일 이전에 방류가 되어야 한다고 보고 있기 때문에 이달 말쯤 방류될 가능성이 높다. 사실 일본 언론이 후쿠시마의 처리수 방류 시기를 구체적으로 언급한 것은 처음이다.\n" +
                        "\n" + "구체적인 방류 시기는 18일 미국 캠프 데이비드에서 한미일 정상회의가 열린 뒤 기시다 후미오 일본 총리가 20일 귀국해 관련 각료회의를 통해 결정할 것으로 보인다.\n" +
                        "\n" + "2023.08.07",
                "",
                R.drawable.sample_5
            ),
            NewsItem(
                "미국 치안 경고등! 대낮 떼강도 사건의 연속, 시민들 공포에 휩싸여...",
                "지난 토요일 대낮에 미국 로스앤젤레스(LA)에서 떼강도 사건이 벌어졌다.\n" +
                        "\n" + "13일(현지 시각) 미국 NBC 방송 등 외신에 따르면 전날 미국 로스앤젤레스(LA) 서부 지역 웨스트필드 토팡가 쇼핑몰에 있는 노드스트롬 백화점에 30∼50명가량의 무리가 한꺼번에 들이닥쳐 최대 10만 달러(약 1억 3000만 원) 상당의 명품 가방과 의류 등을 훔쳐 달아난 것으로 알려졌다.\n" +
                        "\n" +
                        "당시 범행 장면은 영상에 고스란히 담겼고 LA 경찰 등이 소셜미디어에 영상을 올려 사건 매장 내부의 상황을 그대로 보여줬다. 당시 영상을 보면 후드티를 입은 채 모자를 쓰고 복면 등으로 얼굴을 감춘 용의자들이 매장에 들어가 닥치는 대로 고가의 가방 등을 잡히는 대로 훔쳐 밖으로 빠져나갔다.\n" +
                        "\n" + "현지 경찰에 따르면 이들 중 일부는 보안요원에게 야생 곰을 쫓을 때 쓰는 스프레이를 뿌리며 공격을 하고 눈 깜짝할 사이에 기물을 파손하고 물건을 털어간 것으로 알려진다. 이들은 매장에서 명품을 싹쓸이한 뒤 BMW, 렉서스 차량 등을 나눠 타고 도주했다.\n" +
                        "\n" + "LA 경찰은 엑스(옛 트위터)에서 “이날 오후 4시경 강도 일당이 쇼핑몰에서 최소 6만~최대 10만 달러(약 8000만 원~1억 3000만 원)의 물건을 훔쳐 갔다”고 밝히며 “신속하게 현장에 출동해 여러 단서를 확보했다”고 전했다. LA 경찰은 CCTV 영상 등을 토대로 용의자들을 추적하고 있는 것으로 알려졌다.\n" +
                        "\n" +
                        "캐는 배스 LA 시장은 이번 사건에 대해 \"오늘 사건은 절대로 용납할 수 없는 일\"이라며 \"LA 경찰은 이번 사건 범인 추적뿐만 아니라 소매점을 표적으로 한 유사 사건의 재발 방지를 위해서 노력할 것\"이라고 경고했다.\n",
                "2023.08.16",
                R.drawable.sample_7
            )
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(newsItem: NewsItem) =
            TitleFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}