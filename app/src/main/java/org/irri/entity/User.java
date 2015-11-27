package org.irri.entity;

import java.util.List;

/**
 * Created by ACañeda on 2015-11-16.
 */
public class User {


    /**
     * success : true
     * data : {"id":16,"email":"a.caneda@irri.org","username":"a.caneda","last_name":"Caneda","first_name":"Alex","middle_name":null,"display_name":"Caã±Eda, Alex","salutation":null,"remarks":null,"teams":[{"team":{"team_id":3,"program":{"abbrev":"IRSEA","href":"http://api.breeding4rice.irri.org/v1/programs/IRSEA"},"abbrev":"IRSEA","name":"Irrigated South-East Asia","description":"Irrigated South East Asia pipeline team","display_name":"Irrigated South East Asia","members":[{"id":16,"member":"Caã±Eda, Alex","role":"member"},{"id":141,"member":"Ignacio, John Carlos","role":"experience team member"},{"id":27,"member":"Santelices, Ronald","role":"experience team member"},{"id":28,"member":"Collard, Bertrand","role":"Group Leader"},{"id":81,"member":"Lopena, Vitaliano","role":"supervisor"},{"id":83,"member":"Islam, Mohammad Rafiqul","role":"supervisor"},{"id":84,"member":"Shim, Jung-Hyun","role":"supervisor"},{"id":30,"member":"Mendoza, Rhulyx","role":"supervisor"},{"id":82,"member":"Verdeprado, Holden","role":"experience team member"},{"id":18,"member":"Lotho, Connie","role":"data manager"},{"id":222,"member":"Gulles, Alaine","role":"Breeding Informatics"},{"id":223,"member":"Morantte, Rose Imee Zhella","role":"Breeding Informatics"}]}}]}
     */

    private boolean success;
    /**
     * id : 16
     * email : a.caneda@irri.org
     * username : a.caneda
     * last_name : Caneda
     * first_name : Alex
     * middle_name : null
     * display_name : Caã±Eda, Alex
     * salutation : null
     * remarks : null
     * teams : [{"team":{"team_id":3,"program":{"abbrev":"IRSEA","href":"http://api.breeding4rice.irri.org/v1/programs/IRSEA"},"abbrev":"IRSEA","name":"Irrigated South-East Asia","description":"Irrigated South East Asia pipeline team","display_name":"Irrigated South East Asia","members":[{"id":16,"member":"Caã±Eda, Alex","role":"member"},{"id":141,"member":"Ignacio, John Carlos","role":"experience team member"},{"id":27,"member":"Santelices, Ronald","role":"experience team member"},{"id":28,"member":"Collard, Bertrand","role":"Group Leader"},{"id":81,"member":"Lopena, Vitaliano","role":"supervisor"},{"id":83,"member":"Islam, Mohammad Rafiqul","role":"supervisor"},{"id":84,"member":"Shim, Jung-Hyun","role":"supervisor"},{"id":30,"member":"Mendoza, Rhulyx","role":"supervisor"},{"id":82,"member":"Verdeprado, Holden","role":"experience team member"},{"id":18,"member":"Lotho, Connie","role":"data manager"},{"id":222,"member":"Gulles, Alaine","role":"Breeding Informatics"},{"id":223,"member":"Morantte, Rose Imee Zhella","role":"Breeding Informatics"}]}}]
     */

    private DataEntity data;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        private int id;
        private String email;
        private String username;
        private String last_name;
        private String first_name;
        private Object middle_name;
        private String display_name;
        private Object salutation;
        private Object remarks;
        /**
         * team : {"team_id":3,"program":{"abbrev":"IRSEA","href":"http://api.breeding4rice.irri.org/v1/programs/IRSEA"},"abbrev":"IRSEA","name":"Irrigated South-East Asia","description":"Irrigated South East Asia pipeline team","display_name":"Irrigated South East Asia","members":[{"id":16,"member":"Caã±Eda, Alex","role":"member"},{"id":141,"member":"Ignacio, John Carlos","role":"experience team member"},{"id":27,"member":"Santelices, Ronald","role":"experience team member"},{"id":28,"member":"Collard, Bertrand","role":"Group Leader"},{"id":81,"member":"Lopena, Vitaliano","role":"supervisor"},{"id":83,"member":"Islam, Mohammad Rafiqul","role":"supervisor"},{"id":84,"member":"Shim, Jung-Hyun","role":"supervisor"},{"id":30,"member":"Mendoza, Rhulyx","role":"supervisor"},{"id":82,"member":"Verdeprado, Holden","role":"experience team member"},{"id":18,"member":"Lotho, Connie","role":"data manager"},{"id":222,"member":"Gulles, Alaine","role":"Breeding Informatics"},{"id":223,"member":"Morantte, Rose Imee Zhella","role":"Breeding Informatics"}]}
         */

        private List<TeamsEntity> teams;

        public void setId(int id) {
            this.id = id;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public void setMiddle_name(Object middle_name) {
            this.middle_name = middle_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public void setSalutation(Object salutation) {
            this.salutation = salutation;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }

        public void setTeams(List<TeamsEntity> teams) {
            this.teams = teams;
        }

        public int getId() {
            return id;
        }

        public String getEmail() {
            return email;
        }

        public String getUsername() {
            return username;
        }

        public String getLast_name() {
            return last_name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public Object getMiddle_name() {
            return middle_name;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public Object getSalutation() {
            return salutation;
        }

        public Object getRemarks() {
            return remarks;
        }

        public List<TeamsEntity> getTeams() {
            return teams;
        }

        public static class TeamsEntity {
            /**
             * team_id : 3
             * program : {"abbrev":"IRSEA","href":"http://api.breeding4rice.irri.org/v1/programs/IRSEA"}
             * abbrev : IRSEA
             * name : Irrigated South-East Asia
             * description : Irrigated South East Asia pipeline team
             * display_name : Irrigated South East Asia
             * members : [{"id":16,"member":"Caã±Eda, Alex","role":"member"},{"id":141,"member":"Ignacio, John Carlos","role":"experience team member"},{"id":27,"member":"Santelices, Ronald","role":"experience team member"},{"id":28,"member":"Collard, Bertrand","role":"Group Leader"},{"id":81,"member":"Lopena, Vitaliano","role":"supervisor"},{"id":83,"member":"Islam, Mohammad Rafiqul","role":"supervisor"},{"id":84,"member":"Shim, Jung-Hyun","role":"supervisor"},{"id":30,"member":"Mendoza, Rhulyx","role":"supervisor"},{"id":82,"member":"Verdeprado, Holden","role":"experience team member"},{"id":18,"member":"Lotho, Connie","role":"data manager"},{"id":222,"member":"Gulles, Alaine","role":"Breeding Informatics"},{"id":223,"member":"Morantte, Rose Imee Zhella","role":"Breeding Informatics"}]
             */

            private TeamEntity team;

            public void setTeam(TeamEntity team) {
                this.team = team;
            }

            public TeamEntity getTeam() {
                return team;
            }

            public static class TeamEntity {
                private int team_id;
                /**
                 * abbrev : IRSEA
                 * href : http://api.breeding4rice.irri.org/v1/programs/IRSEA
                 */

                private ProgramEntity program;
                private String abbrev;
                private String name;
                private String description;
                private String display_name;
                /**
                 * id : 16
                 * member : Caã±Eda, Alex
                 * role : member
                 */

                private List<MembersEntity> members;

                public void setTeam_id(int team_id) {
                    this.team_id = team_id;
                }

                public void setProgram(ProgramEntity program) {
                    this.program = program;
                }

                public void setAbbrev(String abbrev) {
                    this.abbrev = abbrev;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public void setDisplay_name(String display_name) {
                    this.display_name = display_name;
                }

                public void setMembers(List<MembersEntity> members) {
                    this.members = members;
                }

                public int getTeam_id() {
                    return team_id;
                }

                public ProgramEntity getProgram() {
                    return program;
                }

                public String getAbbrev() {
                    return abbrev;
                }

                public String getName() {
                    return name;
                }

                public String getDescription() {
                    return description;
                }

                public String getDisplay_name() {
                    return display_name;
                }

                public List<MembersEntity> getMembers() {
                    return members;
                }

                public static class ProgramEntity {
                    private String abbrev;
                    private String href;

                    public void setAbbrev(String abbrev) {
                        this.abbrev = abbrev;
                    }

                    public void setHref(String href) {
                        this.href = href;
                    }

                    public String getAbbrev() {
                        return abbrev;
                    }

                    public String getHref() {
                        return href;
                    }
                }

                public static class MembersEntity {
                    private int id;
                    private String member;
                    private String role;

                    public void setId(int id) {
                        this.id = id;
                    }

                    public void setMember(String member) {
                        this.member = member;
                    }

                    public void setRole(String role) {
                        this.role = role;
                    }

                    public int getId() {
                        return id;
                    }

                    public String getMember() {
                        return member;
                    }

                    public String getRole() {
                        return role;
                    }
                }
            }
        }
    }
}
