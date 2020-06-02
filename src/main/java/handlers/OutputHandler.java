package handlers;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.string.StringEncoder;

public class OutputHandler extends ChannelOutboundHandlerAdapter {

    String message;

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("OUT: " + msg);
        message = (String) msg;
        System.out.println(ctx.channel());
        System.out.println(promise.channel());
        ctx.channel().write(message);

    }

    @Override
    public void flush(ChannelHandlerContext ctx) throws Exception {
        super.flush(ctx);
    }
}
