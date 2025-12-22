
val projectConfigs = mapOf(
    "WATER_CAFEBAZAAR" to mapOf(
        "appName" to "Water Bill Inquiry",
        "baseUrl" to "https://api.example.com/water/",
        "marketName" to "Cafebazaar",
        "primaryColor" to "0xFF2196F3",
        "backgroundColor" to "0xFFE3F2FD",
        "textPrimaryColor" to "0xFF0D47A1",
        "titleFa" to "استعلام قبض آب",
        "titleEn" to "Water Bill Inquiry",
        "descriptionFa" to "مشاهده و پرداخت قبض آب",
        "descriptionEn" to "View and pay Water bill",
        "logoRes" to "ic_water_logo"
    ),
    "ELECTRICITY_CAFEBAZAAR" to mapOf(
        "appName" to "Electricity Bill Inquiry",
        "baseUrl" to "https://api.example.com/electricity/",
        "marketName" to "Cafebazaar",
        "primaryColor" to "0xFFFFEB3B",
        "backgroundColor" to "0xFFFFFDE7",
        "textPrimaryColor" to "0xFFFBC02D",
        "titleFa" to "استعلام قبض برق",
        "titleEn" to "Electricity Bill Inquiry",
        "descriptionFa" to "مشاهده و پرداخت قبض برق",
        "descriptionEn" to "View and pay Electricity bill",
        "logoRes" to "ic_electricity_logo"
    ),
    "GAS_CAFEBAZAAR" to mapOf(
        "appName" to "Gas Bill Inquiry",
        "baseUrl" to "https://api.example.com/gas/",
        "marketName" to "Cafebazaar",
        "primaryColor" to "0xFF4CAF50",
        "backgroundColor" to "0xFFE8F5E9",
        "textPrimaryColor" to "0xFF1B5E20",
        "titleFa" to "استعلام قبض گاز",
        "titleEn" to "Gas Bill Inquiry",
        "descriptionFa" to "مشاهده و پرداخت قبض گاز",
        "descriptionEn" to "View and pay Gas bill",
        "logoRes" to "ic_gas_logo"
    ),
    "PHONE_CAFEBAZAAR" to mapOf(
        "appName" to "Phone Bill Inquiry",
        "baseUrl" to "https://api.example.com/phone/",
        "marketName" to "Cafebazaar",
        "primaryColor" to "0xFF9C27B0",
        "backgroundColor" to "0xFFF3E5F5",
        "textPrimaryColor" to "0xFF4A148C",
        "titleFa" to "استعلام قبض تلفن",
        "titleEn" to "Phone Bill Inquiry",
        "descriptionFa" to "مشاهده و پرداخت قبض تلفن ثابت",
        "descriptionEn" to "View and pay Phone bill",
        "logoRes" to "ic_phone_logo"
    ),
    "MOBILE_CAFEBAZAAR" to mapOf(
        "appName" to "Mobile Bill Inquiry",
        "baseUrl" to "https://api.example.com/mobile/",
        "marketName" to "Cafebazaar",
        "primaryColor" to "0xFFFF5722",
        "backgroundColor" to "0xFFFBE9E7",
        "textPrimaryColor" to "0xFFBF360C",
        "titleFa" to "استعلام قبض موبایل",
        "titleEn" to "Mobile Bill Inquiry",
        "descriptionFa" to "مشاهده و پرداخت قبض موبایل",
        "descriptionEn" to "View and pay Mobile bill",
        "logoRes" to "ic_mobile_logo"
    )
)

// Helper to get config by key
fun getProjectConfigByKey(key: String): Map<String, String>? {
    return projectConfigs[key]
}

extra.set("projectConfigs", projectConfigs)
