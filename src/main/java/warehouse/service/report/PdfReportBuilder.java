package warehouse.service.report;


import org.springframework.stereotype.Component;
import warehouse.exception.NotImplementedYet;
import warehouse.model.report.ReportFormat;
import warehouse.model.report.ReportType;

import java.io.File;
import java.util.List;

@Component
public class PdfReportBuilder implements ReportBuilder {

    @Override
    public boolean support(ReportFormat format) {
        return format == ReportFormat.PDF;
    }

    @Override
    public File build(List<String> filteredItems, ReportType type) {
        throw new NotImplementedYet("Pdf reports not implemented yet");
    }
}
