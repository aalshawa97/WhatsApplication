package com.example.whatsapp;

public class CountryToPhonePrefix {
    /*
    public static String getPhone(String code) {
        return country2phone.get(code.toUpperCase());
    }
    public static Map<String, String> getAll(){
        return country2phone;
    }
    private static Map<String, String> country2phone = new HashMap<String, String>();
    static {
        country2phone.put("AF", "+93");
        country2phone.put("AL", "+355");
        country2phone.put("DZ", "+213");
        country2phone.put("AD", "+376");
        country2phone.put("AO", "+244");
        country2phone.put("AG", "+1-268");
        country2phone.put("AR", "+54");
        country2phone.put("AM", "+374");
        country2phone.put("AU", "+61");
        country2phone.put("AT", "+43");
        country2phone.put("AZ", "+994");
        country2phone.put("BS", "+1-242");
        country2phone.put("BH", "+973");
        country2phone.put("BD", "+880");
        country2phone.put("BB", "+1-246");
        country2phone.put("BY", "+375");
        country2phone.put("BE", "+32");
        country2phone.put("BZ", "+501");
        country2phone.put("BJ", "+229");
        country2phone.put("BT", "+975");
        country2phone.put("BO", "+591");
        country2phone.put("BA", "+387");
        country2phone.put("BW", "+267");
        country2phone.put("BR", "+55");
        country2phone.put("BN", "+673");
        country2phone.put("BG", "+359");
        country2phone.put("BF", "+226");
        country2phone.put("BI", "+257");
        country2phone.put("KH", "+855");
        country2phone.put("CM", "+237");
        country2phone.put("CA", "+1");
        country2phone.put("CV", "+238");
        country2phone.put("CF", "+236");
        country2phone.put("TD", "+235");
        country2phone.put("CL", "+56");
        country2phone.put("CN", "+86");
        country2phone.put("CO", "+57");
        country2phone.put("KM", "+269");
        country2phone.put("CD", "+243");
        country2phone.put("CG", "+242");
        country2phone.put("CR", "+506");
        country2phone.put("CI", "+225");
        country2phone.put("HR", "+385");
        country2phone.put("CU", "+53");
        country2phone.put("CY", "+357");
        country2phone.put("CZ", "+420");
        country2phone.put("DK", "+45");
        country2phone.put("DJ", "+253");
        country2phone.put("DM", "+1-767");
        country2phone.put("DO", "+1-809and1-829");
        country2phone.put("EC", "+593");
        country2phone.put("EG", "+20");
        country2phone.put("SV", "+503");
        country2phone.put("GQ", "+240");
        country2phone.put("ER", "+291");
        country2phone.put("EE", "+372");
        country2phone.put("ET", "+251");
        country2phone.put("FJ", "+679");
        country2phone.put("FI", "+358");
        country2phone.put("FR", "+33");
        country2phone.put("GA", "+241");
        country2phone.put("GM", "+220");
        country2phone.put("GE", "+995");
        country2phone.put("DE", "+49");
        country2phone.put("GH", "+233");
        country2phone.put("GR", "+30");
        country2phone.put("GD", "+1-473");
        country2phone.put("GT", "+502");
        country2phone.put("GN", "+224");
        country2phone.put("GW", "+245");
        country2phone.put("GY", "+592");
        country2phone.put("HT", "+509");
        country2phone.put("HN", "+504");
        country2phone.put("HU", "+36");
        country2phone.put("IS", "+354");
        country2phone.put("IN", "+91");
        country2phone.put("ID", "+62");
        country2phone.put("IR", "+98");
        country2phone.put("IQ", "+964");
        country2phone.put("IE", "+353");
        country2phone.put("IL", "+972");
        country2phone.put("IT", "+39");
        country2phone.put("JM", "+1-876");
        country2phone.put("JP", "+81");
        country2phone.put("JO", "+962");
        country2phone.put("KZ", "+7");
        country2phone.put("KE", "+254");
        country2phone.put("KI", "+686");
        country2phone.put("KP", "+850");
        country2phone.put("KR", "+82");
        country2phone.put("KW", "+965");
        country2phone.put("KG", "+996");
        country2phone.put("LA", "+856");
        country2phone.put("LV", "+371");
        country2phone.put("LB", "+961");
        country2phone.put("LS", "+266");
        country2phone.put("LR", "+231");
        country2phone.put("LY", "+218");
        country2phone.put("LI", "+423");
        country2phone.put("LT", "+370");
        country2phone.put("LU", "+352");
        country2phone.put("MK", "+389");
        country2phone.put("MG", "+261");
        country2phone.put("MW", "+265");
        country2phone.put("MY", "+60");
        country2phone.put("MV", "+960");
        country2phone.put("ML", "+223");
        country2phone.put("MT", "+356");
        country2phone.put("MH", "+692");
        country2phone.put("MR", "+222");
        country2phone.put("MU", "+230");
        country2phone.put("MX", "+52");
        country2phone.put("FM", "+691");
        country2phone.put("MD", "+373");
        country2phone.put("MC", "+377");
        country2phone.put("MN", "+976");
        country2phone.put("ME", "+382");
        country2phone.put("MA", "+212");
        country2phone.put("MZ", "+258");
        country2phone.put("MM", "+95");
        country2phone.put("NA", "+264");
        country2phone.put("NR", "+674");
        country2phone.put("NP", "+977");
        country2phone.put("NL", "+31");
        country2phone.put("NZ", "+64");
        country2phone.put("NI", "+505");
        country2phone.put("NE", "+227");
        country2phone.put("NG", "+234");
        country2phone.put("NO", "+47");
        country2phone.put("OM", "+968");
        country2phone.put("PK", "+92");
        country2phone.put("PW", "+680");
        country2phone.put("PA", "+507");
        country2phone.put("PG", "+675");
        country2phone.put("PY", "+595");
        country2phone.put("PE", "+51");
        country2phone.put("PH", "+63");
        country2phone.put("PL", "+48");
        country2phone.put("PT", "+351");
        country2phone.put("QA", "+974");
        country2phone.put("RO", "+40");
        country2phone.put("RU", "+7");
        country2phone.put("RW", "+250");
        country2phone.put("KN", "+1-869");
        country2phone.put("LC", "+1-758");
        country2phone.put("VC", "+1-784");
        country2phone.put("WS", "+685");
        country2phone.put("SM", "+378");
        country2phone.put("ST", "+239");
        country2phone.put("SA", "+966");
        country2phone.put("SN", "+221");
        country2phone.put("RS", "+381");
        country2phone.put("SC", "+248");
        country2phone.put("SL", "+232");
        country2phone.put("SG", "+65");
        country2phone.put("SK", "+421");
        country2phone.put("SI", "+386");
        country2phone.put("SB", "+677");
        country2phone.put("SO", "+252");
        country2phone.put("ZA", "+27");
        country2phone.put("ES", "+34");
        country2phone.put("LK", "+94");
        country2phone.put("SD", "+249");
        country2phone.put("SR", "+597");
        country2phone.put("SZ", "+268");
        country2phone.put("SE", "+46");
        country2phone.put("CH", "+41");
        country2phone.put("SY", "+963");
        country2phone.put("TJ", "+992");
        country2phone.put("TZ", "+255");
        country2phone.put("TH", "+66");
        country2phone.put("TL", "+670");
        country2phone.put("TG", "+228");
        country2phone.put("TO", "+676");
        country2phone.put("TT", "+1-868");
        country2phone.put("TN", "+216");
        country2phone.put("TR", "+90");
        country2phone.put("TM", "+993");
        country2phone.put("TV", "+688");
        country2phone.put("UG", "+256");
        country2phone.put("UA", "+380");
        country2phone.put("AE", "+971");
        country2phone.put("GB", "+44");
        country2phone.put("US", "+1");
        country2phone.put("UY", "+598");
        country2phone.put("UZ", "+998");
        country2phone.put("VU", "+678");
        country2phone.put("VA", "+379");
        country2phone.put("VE", "+58");
        country2phone.put("VN", "+84");
        country2phone.put("YE", "+967");
        country2phone.put("ZM", "+260");
        country2phone.put("ZW", "+263");
        country2phone.put("GE", "+995");
        country2phone.put("TW", "+886");
        country2phone.put("AZ", "+374-97");
        country2phone.put("CY", "+90-392");
        country2phone.put("MD", "+373-533");
        country2phone.put("SO", "+252");
        country2phone.put("GE", "+995");
        country2phone.put("CX", "+61");
        country2phone.put("CC", "+61");
        country2phone.put("NF", "+672");
        country2phone.put("NC", "+687");
        country2phone.put("PF", "+689");
        country2phone.put("YT", "+262");
        country2phone.put("GP", "+590");
        country2phone.put("GP", "+590");
        country2phone.put("PM", "+508");
        country2phone.put("WF", "+681");
        country2phone.put("CK", "+682");
        country2phone.put("NU", "+683");
        country2phone.put("TK", "+690");
        country2phone.put("GG", "+44");
        country2phone.put("IM", "+44");
        country2phone.put("JE", "+44");
        country2phone.put("AI", "+1-264");
        country2phone.put("BM", "+1-441");
        country2phone.put("IO", "+246");
        country2phone.put("", "+357");
        country2phone.put("VG", "+1-284");
        country2phone.put("KY", "+1-345");
        country2phone.put("FK", "+500");
        country2phone.put("GI", "+350");
        country2phone.put("MS", "+1-664");
        country2phone.put("SH", "+290");
        country2phone.put("TC", "+1-649");
        country2phone.put("MP", "+1-670");
        country2phone.put("PR", "+1-787and1-939");
        country2phone.put("AS", "+1-684");
        country2phone.put("GU", "+1-671");
        country2phone.put("VI", "+1-340");
        country2phone.put("HK", "+852");
        country2phone.put("MO", "+853");
        country2phone.put("FO", "+298");
        country2phone.put("GL", "+299");
        country2phone.put("GF", "+594");
        country2phone.put("GP", "+590");
        country2phone.put("MQ", "+596");
        country2phone.put("RE", "+262");
        country2phone.put("AX", "+358-18");
        country2phone.put("AW", "+297");
        country2phone.put("AN", "+599");
        country2phone.put("SJ", "+47");
        country2phone.put("AC", "+247");
        country2phone.put("TA", "+290");
        country2phone.put("CS", "+381");
        country2phone.put("PS", "+970");
        country2phone.put("EH", "+212");
    }
}
    Share
            Edit
Follow
        edited Aug 23, 2014 at 20:53
        answered May 27, 2012 at 17:56
        user avatar
        oshai
        14.1k2525 gold badges7979 silver badges136136 bronze badges
        1
        Could do with a bit of work - lots of repeated empty entries for "AQ", "AU" is set and then unset... –
        Duncan McGregor
        Aug 22, 2014 at 17:38
@Abhi - I wrote it myself. –
        oshai
        Aug 23, 2014 at 20:54
@DuncanMcGregor - Thanks, I think I fixed those entries now. –
        oshai
        Aug 23, 2014 at 20:55
        better change this line: country2phone.put("", "+357"); –
        Kamil Witkowski
        Jul 22, 2016 at 12:21
        1
        Is this line all right? country2phone.put("DO", "+1-809and1-829"); There are a couple other similar ones that might need fixing, too. –
        SpaceBison
        Jan 4, 2018 at 11:26
        Add a comment

        34

        You could use the library called libphonenumber available on Github, made by Google developers. For example you can get the prefix using:

        PhoneNumberUtil.getInstance().getCountryCodeForRegion("DE");
        It also has a lot of useful functions to parse phone numbers.

        Share
        Edit
        Follow
        edited Apr 4, 2019 at 4:41
        user avatar
        Vince
        1,52633 gold badges2525 silver badges4646 bronze badges
        answered Feb 10, 2016 at 9:49
        user avatar
        Shane Murphy
        37933 silver badges66 bronze badges
        Add a comment

        13

        Tidying up @oshai's answer

public class CountryToPhonePrefix {

    private static Map<String, String> map = new HashMap<>();

    public String prefixFor(String iso2CountryCode) {
        String result = map.get(iso2CountryCode);
        if (result == null) {
            throw new IllegalArgumentException("Unknown country code " + iso2CountryCode);
        }
        return result;
    }
    static {
        map.put("AC", "+247");
        map.put("AD", "+376");
        map.put("AE", "+971");
        map.put("AF", "+93");
        map.put("AG", "+1-268");
        map.put("AI", "+1-264");
        map.put("AL", "+355");
        map.put("AM", "+374");
        map.put("AN", "+599");
        map.put("AO", "+244");
        map.put("AR", "+54");
        map.put("AS", "+1-684");
        map.put("AT", "+43");
        map.put("AU", "+61");
        map.put("AW", "+297");
        map.put("AX", "+358-18");
        map.put("AZ", "+374-97");
        map.put("AZ", "+994");
        map.put("BA", "+387");
        map.put("BB", "+1-246");
        map.put("BD", "+880");
        map.put("BE", "+32");
        map.put("BF", "+226");
        map.put("BG", "+359");
        map.put("BH", "+973");
        map.put("BI", "+257");
        map.put("BJ", "+229");
        map.put("BM", "+1-441");
        map.put("BN", "+673");
        map.put("BO", "+591");
        map.put("BR", "+55");
        map.put("BS", "+1-242");
        map.put("BT", "+975");
        map.put("BW", "+267");
        map.put("BY", "+375");
        map.put("BZ", "+501");
        map.put("CA", "+1");
        map.put("CC", "+61");
        map.put("CD", "+243");
        map.put("CF", "+236");
        map.put("CG", "+242");
        map.put("CH", "+41");
        map.put("CI", "+225");
        map.put("CK", "+682");
        map.put("CL", "+56");
        map.put("CM", "+237");
        map.put("CN", "+86");
        map.put("CO", "+57");
        map.put("CR", "+506");
        map.put("CS", "+381");
        map.put("CU", "+53");
        map.put("CV", "+238");
        map.put("CX", "+61");
        map.put("CY", "+90-392");
        map.put("CY", "+357");
        map.put("CZ", "+420");
        map.put("DE", "+49");
        map.put("DJ", "+253");
        map.put("DK", "+45");
        map.put("DM", "+1-767");
        map.put("DO", "+1-809"); // and 1-829?
        map.put("DZ", "+213");
        map.put("EC", "+593");
        map.put("EE", "+372");
        map.put("EG", "+20");
        map.put("EH", "+212");
        map.put("ER", "+291");
        map.put("ES", "+34");
        map.put("ET", "+251");
        map.put("FI", "+358");
        map.put("FJ", "+679");
        map.put("FK", "+500");
        map.put("FM", "+691");
        map.put("FO", "+298");
        map.put("FR", "+33");
        map.put("GA", "+241");
        map.put("GB", "+44");
        map.put("GD", "+1-473");
        map.put("GE", "+995");
        map.put("GF", "+594");
        map.put("GG", "+44");
        map.put("GH", "+233");
        map.put("GI", "+350");
        map.put("GL", "+299");
        map.put("GM", "+220");
        map.put("GN", "+224");
        map.put("GP", "+590");
        map.put("GQ", "+240");
        map.put("GR", "+30");
        map.put("GT", "+502");
        map.put("GU", "+1-671");
        map.put("GW", "+245");
        map.put("GY", "+592");
        map.put("HK", "+852");
        map.put("HN", "+504");
        map.put("HR", "+385");
        map.put("HT", "+509");
        map.put("HU", "+36");
        map.put("ID", "+62");
        map.put("IE", "+353");
        map.put("IL", "+972");
        map.put("IM", "+44");
        map.put("IN", "+91");
        map.put("IO", "+246");
        map.put("IQ", "+964");
        map.put("IR", "+98");
        map.put("IS", "+354");
        map.put("IT", "+39");
        map.put("JE", "+44");
        map.put("JM", "+1-876");
        map.put("JO", "+962");
        map.put("JP", "+81");
        map.put("KE", "+254");
        map.put("KG", "+996");
        map.put("KH", "+855");
        map.put("KI", "+686");
        map.put("KM", "+269");
        map.put("KN", "+1-869");
        map.put("KP", "+850");
        map.put("KR", "+82");
        map.put("KW", "+965");
        map.put("KY", "+1-345");
        map.put("KZ", "+7");
        map.put("LA", "+856");
        map.put("LB", "+961");
        map.put("LC", "+1-758");
        map.put("LI", "+423");
        map.put("LK", "+94");
        map.put("LR", "+231");
        map.put("LS", "+266");
        map.put("LT", "+370");
        map.put("LU", "+352");
        map.put("LV", "+371");
        map.put("LY", "+218");
        map.put("MA", "+212");
        map.put("MC", "+377");
        map.put("MD", "+373-533");
        map.put("MD", "+373");
        map.put("ME", "+382");
        map.put("MG", "+261");
        map.put("MH", "+692");
        map.put("MK", "+389");
        map.put("ML", "+223");
        map.put("MM", "+95");
        map.put("MN", "+976");
        map.put("MO", "+853");
        map.put("MP", "+1-670");
        map.put("MQ", "+596");
        map.put("MR", "+222");
        map.put("MS", "+1-664");
        map.put("MT", "+356");
        map.put("MU", "+230");
        map.put("MV", "+960");
        map.put("MW", "+265");
        map.put("MX", "+52");
        map.put("MY", "+60");
        map.put("MZ", "+258");
        map.put("NA", "+264");
        map.put("NC", "+687");
        map.put("NE", "+227");
        map.put("NF", "+672");
        map.put("NG", "+234");
        map.put("NI", "+505");
        map.put("NL", "+31");
        map.put("NO", "+47");
        map.put("NP", "+977");
        map.put("NR", "+674");
        map.put("NU", "+683");
        map.put("NZ", "+64");
        map.put("OM", "+968");
        map.put("PA", "+507");
        map.put("PE", "+51");
        map.put("PF", "+689");
        map.put("PG", "+675");
        map.put("PH", "+63");
        map.put("PK", "+92");
        map.put("PL", "+48");
        map.put("PM", "+508");
        map.put("PR", "+1-787"); // and 1-939 ?
        map.put("PS", "+970");
        map.put("PT", "+351");
        map.put("PW", "+680");
        map.put("PY", "+595");
        map.put("QA", "+974");
        map.put("RE", "+262");
        map.put("RO", "+40");
        map.put("RS", "+381");
        map.put("RU", "+7");
        map.put("RW", "+250");
        map.put("SA", "+966");
        map.put("SB", "+677");
        map.put("SC", "+248");
        map.put("SD", "+249");
        map.put("SE", "+46");
        map.put("SG", "+65");
        map.put("SH", "+290");
        map.put("SI", "+386");
        map.put("SJ", "+47");
        map.put("SK", "+421");
        map.put("SL", "+232");
        map.put("SM", "+378");
        map.put("SN", "+221");
        map.put("SO", "+252");
        map.put("SO", "+252");
        map.put("SR", "+597");
        map.put("ST", "+239");
        map.put("SV", "+503");
        map.put("SY", "+963");
        map.put("SZ", "+268");
        map.put("TA", "+290");
        map.put("TC", "+1-649");
        map.put("TD", "+235");
        map.put("TG", "+228");
        map.put("TH", "+66");
        map.put("TJ", "+992");
        map.put("TK", "+690");
        map.put("TL", "+670");
        map.put("TM", "+993");
        map.put("TN", "+216");
        map.put("TO", "+676");
        map.put("TR", "+90");
        map.put("TT", "+1-868");
        map.put("TV", "+688");
        map.put("TW", "+886");
        map.put("TZ", "+255");
        map.put("UA", "+380");
        map.put("UG", "+256");
        map.put("US", "+1");
        map.put("UY", "+598");
        map.put("UZ", "+998");
        map.put("VA", "+379");
        map.put("VC", "+1-784");
        map.put("VE", "+58");
        map.put("VG", "+1-284");
        map.put("VI", "+1-340");
        map.put("VN", "+84");
        map.put("VU", "+678");
        map.put("WF", "+681");
        map.put("WS", "+685");
        map.put("YE", "+967");
        map.put("YT", "+262");
        map.put("ZA", "+27");
        map.put("ZM", "+260");
        map.put("ZW", "+263");
    }
    */
}
