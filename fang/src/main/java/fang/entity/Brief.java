package fang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "month_briefs")
public class Brief extends BaseEntity {
    String title;
    String sourceState;
    String yuSHou;
    @Transient
    Long monthId;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "month_id")
    @JsonIgnore
    Month month;

    @OneToMany(mappedBy = "brief",fetch = FetchType.EAGER)
    Set<BriefContent> briefContents;

    public Set<BriefContent> getBriefContents() {
        return briefContents;
    }

    public void setBriefContents(Set<BriefContent> briefContents) {
        this.briefContents = briefContents;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSourceState() {
        return sourceState;
    }

    public void setSourceState(String sourceState) {
        this.sourceState = sourceState;
    }

    public String getYuSHou() {
        return yuSHou;
    }

    public void setYuSHou(String yuSHou) {
        this.yuSHou = yuSHou;
    }

    public Long getMonthId() {
        return monthId;
    }

    public void setMonthId(Long monthId) {
        this.monthId = monthId;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }
}
