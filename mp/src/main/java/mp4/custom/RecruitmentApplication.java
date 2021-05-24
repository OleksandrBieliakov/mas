package mp4.custom;

public class RecruitmentApplication {

    private String candidateName;
    private Education education;
    private int yearsOfExperience;

    public RecruitmentApplication(String name, Education education, int yearsOfExperience) {
        setName(name);
        setEducation(education);
        setYearsOfExperience(yearsOfExperience);
    }

    public String getName() {
        return candidateName;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.candidateName = name;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        if (yearsOfExperience < 0) {
            throw new IllegalArgumentException("cannot be negative");
        }
        if (yearsOfExperience < education.getMinYearsOfExperience()) {
            throw new IllegalArgumentException("CANNOT APPLY: too little experience for given education");
        }
        this.yearsOfExperience = yearsOfExperience;
    }
}
