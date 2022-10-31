package warehouse.service.report;


import org.springframework.stereotype.Component;
import warehouse.model.report.ReportFormat;
import warehouse.model.report.ReportType;

import java.io.File;
import java.util.List;

@Component
public class CsvReportBuilder implements ReportBuilder {
    @Override
    public boolean support(ReportFormat format) {
        return format == ReportFormat.CSV;

    }

    @Override
    public File build(List<String> filteredItems, ReportType type) {
        return null;
    }
}
