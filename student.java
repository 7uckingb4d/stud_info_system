public class studentInfo {

    private final int STUDID;
    private final String STUDFNAME;
    private final String STUDLNAME;
    private final String STUDMNAME;
    private final int STUDYEAR;
    private final String STUDSECTION;
    private final String STUDPROG;
    private final String STUDADDRESS;
    private final String STUDEMAIL;
    private final String STUDPHONE;

    private studentInfo(StudentBuilder builder) {
        this.STUDID = builder.STUDID;
        this.STUDFNAME = builder.STUDFNAME;
        this.STUDLNAME = builder.STUDLNAME;
        this.STUDMNAME = builder.STUDMNAME;
        this.STUDYEAR = builder.STUDYEAR;
        this.STUDSECTION = builder.STUDSECTION;
        this.STUDPROG = builder.STUDPROG;
        this.STUDADDRESS = builder.STUDADDRESS;
        this.STUDEMAIL = builder.STUDEMAIL;
        this.STUDPHONE = builder.STUDPHONE;
    }

    // PUBLIC GETTERS TO READ PRIVATE DATAS
    int getSTUDID() {
        return this.STUDID; 
    }
    String getSTUDFNAME() {
        return this.STUDFNAME; }
    String getSTUDLNAME() { 
        return this.STUDLNAME; 
    }
    public String getSTUDMNAME() {
        return STUDMNAME; 
    }
    int getSTUDYEAR() {
        return STUDYEAR; 
    }
    String getSTUDSECTION() {
        return STUDSECTION;
    }
    String getSTUDPROG() { 
        return STUDPROG; 
    }
    String getSTUDADDRESS() { 
        return STUDADDRESS; 
    }
    String getSTUDEMAIL() {
        return STUDEMAIL; 
    }
    String getSTUDPHONE() {
        return STUDPHONE; 
    }
    

    public static class StudentBuilder {
        private int STUDID;
        private String STUDFNAME;
        private String STUDLNAME;
        private String STUDMNAME;
        private int STUDYEAR;
        private String STUDSECTION;
        private String STUDPROG;
        private String STUDADDRESS;
        private String STUDEMAIL;
        private String STUDPHONE;

        public StudentBuilder setSTUDID(int id) {
            this.STUDID = id;
            return this; 
        }
        public StudentBuilder setSTUDFNAME(String fn) {
            this.STUDFNAME = fn;
            return this; 
        }
        public StudentBuilder setSTUDLNAME(String ln) {
            this.STUDLNAME = ln; 
            return this; 
        }
        public StudentBuilder setSTUDMNAME(String mn) {
            this.STUDMNAME = mn; 
            return this; 
        }
        public StudentBuilder setSTUDYEAR(int yr) {
            this.STUDYEAR = yr; 
            return this; 
        }
        public StudentBuilder setSTUDSECTION(String sec) {
            this.STUDSECTION = sec; 
            return this; 
        }
        public StudentBuilder setSTUDPROG(String pr) {
            this.STUDPROG = pr; 
            return this; 
        }
        public StudentBuilder setSTUDADDRESS(String ad) {
            this.STUDADDRESS = ad; 
            return this; 
        }
        public StudentBuilder setSTUDEMAIL(String em) {
            this.STUDEMAIL = em;
            return this; 
        }
        public StudentBuilder setSTUDPHONE(String ph) { 
            this.STUDPHONE = ph; 
            return this; 
        }
        public studentInfo BuildStudent() {
            return new studentInfo(this);
        }    
    }
}