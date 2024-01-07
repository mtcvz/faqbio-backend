package io.faqb.groups.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="groups_table", schema = "faqbiodb")
public class GroupsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private int groupId;

	@Column(name = "group_name")
	private String groupName;

	@Column(name = "group_icon")
	private String groupIcon;

	@Column(name = "user_id")
	private int userId;
}
