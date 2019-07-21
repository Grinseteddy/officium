package com.annegret.officium.taskmanagement.entities;

public class link {

    public enum linkType {
        PDF,
        HyperLink
    }

    public enum relation {
        Object,
        Assignee,
        Thread
    }

    private String href;

    private linkType linkType;

    private relation relation;

    public link() {

    }

    public link (String href, linkType linkType, relation relation) {
        this.href=href;
        this.linkType=linkType;
        this.relation=relation;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public link.linkType getLinkType() {
        return linkType;
    }

    public void setLinkType(link.linkType linkType) {
        this.linkType = linkType;
    }

    public link.relation getRelation() {
        return relation;
    }

    public void setRelation(link.relation relation) {
        this.relation = relation;
    }
}
