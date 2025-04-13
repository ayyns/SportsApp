package com.dicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("teams")
	val teams: List<TeamsItem?>? = null
)

data class TeamsItem(

	@field:SerializedName("intStadiumCapacity")
	val intStadiumCapacity: String? = null,

	@field:SerializedName("strTeamShort")
	val strTeamShort: String? = null,

	@field:SerializedName("idLeague3")
	val idLeague3: String? = null,

	@field:SerializedName("idESPN")
	val idESPN: String? = null,

	@field:SerializedName("idLeague2")
	val idLeague2: String? = null,

	@field:SerializedName("idLeague5")
	val idLeague5: Any? = null,

	@field:SerializedName("strSport")
	val strSport: String? = null,

	@field:SerializedName("idLeague4")
	val idLeague4: String? = null,

	@field:SerializedName("idLeague7")
	val idLeague7: Any? = null,

	@field:SerializedName("strDescriptionCN")
	val strDescriptionCN: Any? = null,

	@field:SerializedName("idLeague6")
	val idLeague6: Any? = null,

	@field:SerializedName("intLoved")
	val intLoved: String? = null,

	@field:SerializedName("idLeague")
	val idLeague: String? = null,

	@field:SerializedName("strBadge")
	val strBadge: String? = null,

	@field:SerializedName("strLocation")
	val strLocation: String? = null,

	@field:SerializedName("strDescriptionSE")
	val strDescriptionSE: Any? = null,

	@field:SerializedName("strDescriptionJP")
	val strDescriptionJP: String? = null,

	@field:SerializedName("strFanart1")
	val strFanart1: String? = null,

	@field:SerializedName("strDescriptionFR")
	val strDescriptionFR: String? = null,

	@field:SerializedName("strFanart2")
	val strFanart2: String? = null,

	@field:SerializedName("strFanart3")
	val strFanart3: String? = null,

	@field:SerializedName("strFanart4")
	val strFanart4: String? = null,

	@field:SerializedName("strDescriptionNL")
	val strDescriptionNL: Any? = null,

	@field:SerializedName("strCountry")
	val strCountry: String? = null,

	@field:SerializedName("strRSS")
	val strRSS: String? = null,

	@field:SerializedName("strDescriptionRU")
	val strDescriptionRU: String? = null,

	@field:SerializedName("strLogo")
	val strLogo: String? = null,

	@field:SerializedName("strDescriptionNO")
	val strDescriptionNO: String? = null,

	@field:SerializedName("strDescriptionES")
	val strDescriptionES: String? = null,

	@field:SerializedName("intFormedYear")
	val intFormedYear: String? = null,

	@field:SerializedName("strBanner")
	val strBanner: String? = null,

	@field:SerializedName("strInstagram")
	val strInstagram: String? = null,

	@field:SerializedName("strDescriptionIT")
	val strDescriptionIT: String? = null,

	@field:SerializedName("idTeam")
	val idTeam: String? = null,

	@field:SerializedName("strDescriptionEN")
	val strDescriptionEN: String? = null,

	@field:SerializedName("strTeamAlternate")
	val strTeamAlternate: String? = null,

	@field:SerializedName("strWebsite")
	val strWebsite: String? = null,

	@field:SerializedName("strYoutube")
	val strYoutube: String? = null,

	@field:SerializedName("strDescriptionIL")
	val strDescriptionIL: Any? = null,

	@field:SerializedName("idAPIfootball")
	val idAPIfootball: String? = null,

	@field:SerializedName("strLocked")
	val strLocked: String? = null,

	@field:SerializedName("strColour3")
	val strColour3: String? = null,

	@field:SerializedName("strEquipment")
	val strEquipment: String? = null,

	@field:SerializedName("strTeam")
	val strTeam: String? = null,

	@field:SerializedName("strTwitter")
	val strTwitter: String? = null,

	@field:SerializedName("strDescriptionHU")
	val strDescriptionHU: Any? = null,

	@field:SerializedName("strColour2")
	val strColour2: String? = null,

	@field:SerializedName("strColour1")
	val strColour1: String? = null,

	@field:SerializedName("strGender")
	val strGender: String? = null,

	@field:SerializedName("strDivision")
	val strDivision: Any? = null,

	@field:SerializedName("idVenue")
	val idVenue: String? = null,

	@field:SerializedName("strStadium")
	val strStadium: String? = null,

	@field:SerializedName("strFacebook")
	val strFacebook: String? = null,

	@field:SerializedName("strLeague2")
	val strLeague2: String? = null,

	@field:SerializedName("strLeague3")
	val strLeague3: String? = null,

	@field:SerializedName("strLeague4")
	val strLeague4: String? = null,

	@field:SerializedName("strLeague5")
	val strLeague5: String? = null,

	@field:SerializedName("strDescriptionPT")
	val strDescriptionPT: String? = null,

	@field:SerializedName("strLeague6")
	val strLeague6: String? = null,

	@field:SerializedName("strDescriptionDE")
	val strDescriptionDE: String? = null,

	@field:SerializedName("strLeague7")
	val strLeague7: String? = null,

	@field:SerializedName("strLeague")
	val strLeague: String? = null,

	@field:SerializedName("strKeywords")
	val strKeywords: String? = null,

	@field:SerializedName("strDescriptionPL")
	val strDescriptionPL: Any? = null
)
