package warehouse.service.report;


import warehouse.model.report.ReportFormat;
import warehouse.model.report.ReportType;

import java.io.File;
import java.util.List;

public interface ReportBuilder {
    boolean support(ReportFormat format);
    File build(List<String> filteredItems, ReportType type);
}
