package org.unidal.cat.plugin.transactions.reducer;

import org.unidal.cat.plugin.transactions.TransactionsConstants;
import org.unidal.cat.plugin.transactions.model.entity.TransactionsRange;
import org.unidal.cat.plugin.transactions.model.entity.TransactionsReport;
import org.unidal.cat.spi.ReportPeriod;
import org.unidal.cat.spi.report.ReportReducer;
import org.unidal.helper.Dates;
import org.unidal.lookup.annotation.Named;

@Named(type = ReportReducer.class, value = TransactionsConstants.NAME + ":" + TransactionsMonthlyReducer.ID)
public class TransactionsMonthlyReducer extends AbstractTransactionsReducer implements ReportReducer<TransactionsReport> {
	public static final String ID = MONTHLY;

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public ReportPeriod getPeriod() {
		return ReportPeriod.MONTH;
	}

	@Override
	protected int getRangeValue(TransactionsReport report, TransactionsRange range) {
		int day = Dates.from(report.getStartTime()).day();

		return day;
	}
}
