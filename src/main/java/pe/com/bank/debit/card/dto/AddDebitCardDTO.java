package pe.com.bank.debit.card.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddDebitCardDTO {
	
	private Long numberCard;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date openingDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
	private Integer cvv;
	private String onlinePayment;
	private String customerId;
	private String accountId;

}
