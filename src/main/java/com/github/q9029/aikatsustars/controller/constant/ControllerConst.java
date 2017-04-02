package com.github.q9029.aikatsustars.controller.constant;

public class ControllerConst {

    /**
     * 定数クラスのため、コンストラクタは使用しない.
     */
    private ControllerConst() {}

    /**
     * Controllerで使用するURIの定数クラス.
     */
    public class Uri {

        public static final String INDEX = "/";

        public static final String SIGNIN = "/signin";

        public static final String SIGNOUT = "/signout";

        public static final String CALLBACK = "/callback";

        public static final String PRIVACYPOLICY = "/privacypolicy";

        public static final String TERMS = "/terms";

        public static final String CLEAN_ACCOUNTS = "/clean-accounts";

        public static final String OTHERS = "/**";
    }

    /**
     * Controllerで使用するレスポンスファイルの定数クラス.<br>
     * prefix : /WEB-INF/views/
     */
    public class View {

        public static final String INDEX = "index.jsp";

        public static final String INDEX_SIGNIN = "signin.jsp";

        public static final String PRIVACYPOLICY = "privacypolicy.jsp";

        public static final String TERMS = "terms.jsp";

        public static final String ERROR = "404.jsp";
    }

    /**
     * HttpServletRequestで使用するキーの定数クラス.
     */
    public class Request {

        public static final String OAUTH_VERIFIER = "oauth_verifier";

        public static final String TWEET = "tweet";
    }

    /**
     * HttpSessionで使用するキーの定数クラス.
     */
    public class Session {

        public static final String TWITTER = "twitter";

        public static final String TWITTER_REQUEST_TOKEN = "request_token";
    }
}
