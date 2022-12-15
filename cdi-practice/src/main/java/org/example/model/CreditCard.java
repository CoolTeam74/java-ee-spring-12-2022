package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreditCard {
    @XmlAttribute(required = true)
    private String number;
    @XmlAttribute(required = true)
    private String owner;
    @XmlAttribute(required = true)
    private String expiryDate;
    @XmlAttribute(required = true)
    private String type;
}
