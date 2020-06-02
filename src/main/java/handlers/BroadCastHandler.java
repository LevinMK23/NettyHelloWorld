package handlers;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.channels.SocketChannel;
import java.util.concurrent.ConcurrentLinkedDeque;

public class BroadCastHandler extends ChannelInboundHandlerAdapter {

    static ConcurrentLinkedDeque<Channel> channels = new ConcurrentLinkedDeque<>();
    static int cnt = 0;

    public BroadCastHandler() {
        super();
        //channels = new ConcurrentLinkedDeque<>();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        cnt++;
        String name = "User#" + cnt;
        channels.add(ctx.channel());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        System.out.println(msg);
        for (Channel channel : channels) {
            channel.writeAndFlush(message);
            System.out.println("channel: " + channel);
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        channels.remove(ctx.channel());
    }
}
