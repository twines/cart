package fang.entity;

import javax.persistence.*;

@Entity
@Table(name = "month_brief_contents")
public class BriefContent extends BaseEntity {

    String content;
    @Transient
    Long monthBriefId;

    @ManyToOne
    @JoinColumn(name = "month_brief_id")

    Brief brief;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getMonthBriefId() {
        return this.brief.getId();
    }


}
