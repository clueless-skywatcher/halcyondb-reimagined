package com.github.cluelessskywatcher.halcyonreimagined.halql;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;
import com.github.cluelessskywatcher.halcyonreimagined.halql.generated.HalcyonQueryLanguageLexer;
import com.github.cluelessskywatcher.halcyonreimagined.halql.generated.HalcyonQueryLanguageParser;

public class HalqlParserEngine {
    public static HalqlStatement parseQuery(InputBuffer buffer) throws IOException {
        String query = buffer.getBuffer();
        InputStream inputStream = new ByteArrayInputStream(query.getBytes(StandardCharsets.UTF_8));
        HalcyonQueryLanguageLexer lexer = new HalcyonQueryLanguageLexer(CharStreams.fromStream(inputStream));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        HalcyonQueryLanguageParser parser = new HalcyonQueryLanguageParser(tokenStream);
        
        ParseTree tree = parser.halqlEntryPoint();
        HalqlVisitor visitor = new HalqlVisitor();
        HalqlStatement stmt = visitor.visit(tree);
        return stmt;
    }
}
