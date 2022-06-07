package housekeeping.tineretului.dto;

import java.math.BigDecimal;
import java.sql.Date;

public class IntretinereRequest {
    private BigDecimal amount;
    private Date createdDate;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
