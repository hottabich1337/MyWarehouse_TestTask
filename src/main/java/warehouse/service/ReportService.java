package warehouse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import warehouse.model.report.ReportFormat;
import warehouse.model.report.ReportType;
import warehouse.service.report.ReportBuilder;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    List<ReportBuilder> builders;

    public File buildReport(ReportType type, ReportFormat format, List<String> filteredItems) {
        Optional<ReportBuilder> matchedBuilder = builders.stream()
                .filter(builder -> builder.support(format))
                .findFirst();
        if (matchedBuilder.isEmpty()) {
            throw new RuntimeException("No report builders found for " + format + " format");
        }
        return matchedBuilder.get().build(filteredItems, type);
    }

}
